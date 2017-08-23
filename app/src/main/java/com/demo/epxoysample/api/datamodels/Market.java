package com.demo.epxoysample.api.datamodels;

/**
 * Created by chiu on 2017/8/22.
 */

public class Market {
    private String _id;
    private String stitle;
    private String xbody;
    private String xcreatedDate;
    private String xAddress;
    private String GTag_longitude;
    private String GTag_latitude;

    public String get_id() {
        return _id;
    }

    public String getStitle() {
        return stitle;
    }

    public String getXbody() {
        return xbody;
    }

    public String getXcreatedDate() {
        return xcreatedDate;
    }

    public String getxAddress() {
        return xAddress;
    }

    public String getGTag_longitude() {
        return GTag_longitude;
    }

    public String getGTag_latitude() {
        return GTag_latitude;
    }
}
