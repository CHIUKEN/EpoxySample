package com.demo.epxoysample.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.demo.epxoysample.R;
import com.demo.epxoysample.api.datamodels.Store;
import com.demo.epxoysample.controller.ScrollViewController;
import com.demo.epxoysample.repositories.DataRepository;
import com.demo.epxoysample.view.GroupItemView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScrollViewActivity extends AppCompatActivity implements GroupItemView.PhoneCallBack {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private ScrollViewController mScrollViewController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
        ButterKnife.bind(this);
        mScrollViewController = new ScrollViewController(DataRepository.getInstance().getStoreData(), this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mScrollViewController.getAdapter());
        mScrollViewController.requestModelBuild();
    }

    @Override
    public void onPhoneCall(String phone) {
        Toast.makeText(this, phone, Toast.LENGTH_SHORT).show();
    }
}
