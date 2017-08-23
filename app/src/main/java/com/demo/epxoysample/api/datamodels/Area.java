package com.demo.epxoysample.api.datamodels;

import java.util.List;

/**
 * Created by chiu on 2017/8/21.
 */

public class Area {
    private String ZipCode;
    private String AreaName;
    private String AreaEngName;
    private List<Road> RoadList;

    public List<Road> getRoadList() {
        return RoadList;
    }

    public String getAreaEngName() {
        return AreaEngName;
    }

    public String getAreaName() {
        return AreaName;
    }

    public String getZipCode() {
        return ZipCode;
    }
}
