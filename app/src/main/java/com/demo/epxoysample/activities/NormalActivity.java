package com.demo.epxoysample.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.demo.epxoysample.R;
import com.demo.epxoysample.controller.NormalController;
import com.demo.epxoysample.listeners.AdapterCallbacks;
import com.demo.epxoysample.api.datamodels.SampleData;
import com.demo.epxoysample.repositories.DataRepository;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NormalActivity extends AppCompatActivity implements AdapterCallbacks<SampleData> {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private NormalController mNormalController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        ButterKnife.bind(this);
        mNormalController = new NormalController(this, this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mNormalController.getAdapter());
        List<SampleData> dataList = DataRepository.getInstance().getDatas();
        mNormalController.setData(dataList);
    }

    @Override
    public void onItemClicked(SampleData data, int dataPosition) {
        Toast.makeText(this, "clicked " + dataPosition, Toast.LENGTH_LONG).show();
    }
}
