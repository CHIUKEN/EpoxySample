package com.demo.epxoysample.api.datamodels;

import android.support.annotation.ColorInt;

/**
 * Created by chiu on 2017/8/18.
 */

public class ColorData {
    private final long id;
    @ColorInt
    private int colorInt;

    public ColorData(int colorInt, long id) {
        this.colorInt = colorInt;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @ColorInt
    public int getColorInt() {
        return colorInt;
    }

    public void setColorInt(@ColorInt int colorInt) {
        this.colorInt = colorInt;
    }
}
