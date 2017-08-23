package com.demo.epxoysample.api.datamodels;

import java.util.List;

/**
 * Created by chiu on 2017/8/21.
 */

public class City {
    private String CityName;
    private String CityEngName;
    private List<Area> AreaList;

    public List<Area> getAreaList() {
        return AreaList;
    }

    public String getCityEngName() {
        return CityEngName;
    }

    public String getCityName() {
        return CityName;
    }
}
