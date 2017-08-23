package com.demo.epxoysample.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.demo.epxoysample.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_normal)
    void OnNormalClick() {
        Intent intent = new Intent(this, NormalActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_grid)
    void OnGridClick() {
        Intent intent = new Intent(this, GridActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_multi_type)
    void OnMultiTypeClick() {
        Intent intent = new Intent(this, ScrollViewActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_group)
    void OnGroupClick() {
        Intent intent = new Intent(this, GroupActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_api)
    void OnApiClick() {
        Intent intent = new Intent(this, ApiActivity.class);
        startActivity(intent);
    }
}
