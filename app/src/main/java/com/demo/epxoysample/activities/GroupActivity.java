package com.demo.epxoysample.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.demo.epxoysample.R;
import com.demo.epxoysample.controller.AddressController;
import com.demo.epxoysample.api.datamodels.City;
import com.demo.epxoysample.repositories.DataRepository;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GroupActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.progressbar)
    ProgressBar mProgressBar;
    private AddressController mAddressController;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        ButterKnife.bind(this);
        mAddressController = new AddressController(this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAddressController.getAdapter());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Disposable d = Flowable.create((FlowableOnSubscribe<List<City>>) e -> {
            List<City> cityList = DataRepository.getInstance().getAllCity(this);
            e.onNext(cityList);
            e.onComplete();
        }, BackpressureStrategy.BUFFER)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(subscription -> mProgressBar.setVisibility(View.VISIBLE))
                .doFinally(() -> mProgressBar.setVisibility(View.GONE))
                .subscribe(cities -> {
                    mAddressController.setData(cities);
                }, throwable -> {
                    Log.e("error", throwable.getMessage());
                });
        mCompositeDisposable.add(d);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.clear();
    }
}
