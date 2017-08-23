package com.demo.epxoysample.controller;

import android.content.Context;

import com.airbnb.epoxy.AutoModel;
import com.airbnb.epoxy.TypedEpoxyController;
import com.demo.epxoysample.listeners.AdapterCallbacks;
import com.demo.epxoysample.api.datamodels.SampleData;
import com.demo.epxoysample.viewholders.SampleDataModel_;
import com.demo.epxoysample.view.HeaderViewModel_;

import java.util.List;

/**
 * Created by chiu on 2017/8/18.
 */

public class NormalController extends TypedEpoxyController<List<SampleData>> {
    private final Context context;
    private final AdapterCallbacks callbacks;
    @AutoModel
    HeaderViewModel_ mHeaderViewModel;

    public NormalController(Context context, AdapterCallbacks callbacks) {
        this.context = context;
        this.callbacks = callbacks;
    }

    @Override
    protected void buildModels(List<SampleData> datas) {
        mHeaderViewModel
                .title("This is header view")
                .caption("test")
                .addTo(this);
        for (SampleData data : datas) {
            new SampleDataModel_()
                    .id(data.getId())
                    .comment(data.getData())
                    .clickListener((model, parentView, clickedView, position) -> {
                        callbacks.onItemClicked(data, position);
                    })
                    .addTo(this);
        }

    }
}
