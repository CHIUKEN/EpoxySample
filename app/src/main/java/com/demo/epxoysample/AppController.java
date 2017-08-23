package com.demo.epxoysample;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by chiu on 2017/8/22.
 */

public class AppController extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
