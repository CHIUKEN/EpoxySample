package com.demo.epxoysample.controller;

import android.content.Context;

import com.airbnb.epoxy.TypedEpoxyController;
import com.demo.epxoysample.R;
import com.demo.epxoysample.viewholders.AddressModel_;
import com.demo.epxoysample.api.datamodels.Area;
import com.demo.epxoysample.api.datamodels.City;
import com.demo.epxoysample.api.datamodels.Road;

import java.util.List;

/**
 * Created by chiu on 2017/8/21.
 */

public class AddressController extends TypedEpoxyController<List<City>> {
    private Context mContext;

    public AddressController(Context context) {
        mContext = context;
    }

    @Override
    protected void buildModels(List<City> data) {
        for (City c : data) {
            new AddressModel_()
                    .id(c.hashCode())
                    .name(c.getCityName())
                    .color(mContext.getResources().getColor(R.color.colorPrimary))
                    .addTo(this);
            for (Area area : c.getAreaList()) {
                new AddressModel_()
                        .id(area.hashCode())
                        .name(area.getAreaName())
                        .color(mContext.getResources().getColor(R.color.colorAccent))
                        .addTo(this);
                for (Road road :
                        area.getRoadList()) {
                    new AddressModel_()
                            .id(road.hashCode())
                            .name(road.getRoadName())
                            .addTo(this);

                }
            }
        }
    }
}
