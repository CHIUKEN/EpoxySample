package com.demo.epxoysample.api.datamodels;

/**
 * Created by chiu on 2017/8/22.
 */

public class Store {
    private String storeName;
    private String phone;

    public Store(String storeName, String phone) {
        this.storeName = storeName;
        this.phone = phone;
    }

    public String getStoreName() {
        return storeName;
    }


    public String getPhone() {
        return phone;
    }

}
