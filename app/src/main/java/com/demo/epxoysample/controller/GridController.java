package com.demo.epxoysample.controller;

import android.view.View;

import com.airbnb.epoxy.AutoModel;
import com.airbnb.epoxy.OnModelClickListener;
import com.airbnb.epoxy.TypedEpoxyController;
import com.demo.epxoysample.api.datamodels.ColorData;
import com.demo.epxoysample.listeners.AdapterCallbacks;
import com.demo.epxoysample.viewholders.ColorModel;
import com.demo.epxoysample.viewholders.ColorModel_;
import com.demo.epxoysample.view.HeaderViewModel_;

import java.util.List;

/**
 * Created by chiu on 2017/8/18.
 */

public class GridController extends TypedEpoxyController<List<ColorData>> {
    @AutoModel
    HeaderViewModel_ mHeaderViewModel;
    private final AdapterCallbacks<ColorData> callbacks;

    public GridController(AdapterCallbacks<ColorData> callbacks) {
        this.callbacks = callbacks;
    }

    @Override
    protected void buildModels(List<ColorData> datas) {
        mHeaderViewModel
                .caption("color")
                .title("Grid Sample")
                .addTo(this);

        for (ColorData data : datas) {
            new ColorModel_().id(data.getId())
                    .color(data.getColorInt())
                    .clickListener((model, parentView, clickedView, position) -> {
                        callbacks.onItemClicked(data, position);
                    })
                    .addTo(this);
        }
    }
}
