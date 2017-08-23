package com.demo.epxoysample.listeners;

import com.demo.epxoysample.api.datamodels.SampleData;

/**
 * Created by chiu on 2017/8/18.
 */

public interface AdapterCallbacks<T> {
    void onItemClicked(T data, int dataPosition);
}
