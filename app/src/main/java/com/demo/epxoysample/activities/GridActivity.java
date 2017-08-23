package com.demo.epxoysample.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.demo.epxoysample.R;
import com.demo.epxoysample.VerticalGridCardSpacingDecoration;
import com.demo.epxoysample.api.datamodels.ColorData;
import com.demo.epxoysample.controller.GridController;
import com.demo.epxoysample.listeners.AdapterCallbacks;
import com.demo.epxoysample.repositories.DataRepository;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GridActivity extends AppCompatActivity implements AdapterCallbacks<ColorData> {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private GridController mGridController = new GridController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        ButterKnife.bind(this);
        mGridController.setData(DataRepository.getInstance().getColorData());

        mRecyclerView.setHasFixedSize(true);
        mGridController.setSpanCount(2);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(mGridController.getSpanSizeLookup());
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.addItemDecoration(new VerticalGridCardSpacingDecoration());
        mRecyclerView.setAdapter(mGridController.getAdapter());
    }

    @Override
    public void onItemClicked(ColorData data, int dataPosition) {
        Toast.makeText(this, "You click" + dataPosition, Toast.LENGTH_SHORT).show();
    }
}
