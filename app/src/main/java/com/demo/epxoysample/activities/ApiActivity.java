package com.demo.epxoysample.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.demo.epxoysample.R;
import com.demo.epxoysample.api.datamodels.Market;
import com.demo.epxoysample.controller.ApiController;
import com.demo.epxoysample.listeners.EndlessRecyclerOnScrollListener;
import com.demo.epxoysample.repositories.DataRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class ApiActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private ApiController mApiController;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private volatile int mPage = 0;
    private Disposable mDisposable;
    private int mMaxCount;
    private int mLimit = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        ButterKnife.bind(this);
        mApiController = new ApiController();

        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mApiController.getAdapter());
        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int current_page) {
                getApiData();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        getApiData();
    }

    private void getApiData() {
        if (mMaxCount != 0) {
            if (mPage > mMaxCount) {
                mApiController.setLoadingMore(false);
                return;
            }
        }
        if (mDisposable != null) {
            if (!mDisposable.isDisposed()) {
                return;
            }
        }
        mDisposable = DataRepository.getInstance().getMarkets("resourceAquire", "9cf059a3-3fdd-4630-8252-da95d6e78b2c", mPage, mLimit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(apiResult -> {
                    mMaxCount = apiResult.getCount();
                    if (apiResult.getResults().size() > 0) {
                        mPage = mPage + mLimit;
                        mApiController.addMarkets(apiResult.getResults());
                        mApiController.setLoadingMore(true);
                    } else {
                        mApiController.addMarkets(apiResult.getResults());
                        mApiController.setLoadingMore(false);
                    }
                }, throwable -> {
                    Timber.e(throwable);
                });
        mCompositeDisposable.add(mDisposable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.clear();
    }
}
