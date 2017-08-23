package com.demo.epxoysample.repositories;

import android.content.Context;
import android.graphics.Color;

import com.demo.epxoysample.api.RestClient;
import com.demo.epxoysample.api.datamodels.ApiResult;
import com.demo.epxoysample.api.datamodels.City;
import com.demo.epxoysample.api.datamodels.ColorData;
import com.demo.epxoysample.api.datamodels.DataResult;
import com.demo.epxoysample.api.datamodels.Market;
import com.demo.epxoysample.api.datamodels.SampleData;
import com.demo.epxoysample.api.datamodels.Store;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by chiu on 2017/8/18.
 */

public class DataRepository {

    private static volatile DataRepository sInstance;
    private static final Random RANDOM = new Random();

    public static DataRepository getInstance() {
        if (sInstance == null) {
            synchronized (DataRepository.class) {
                if (sInstance == null) {
                    sInstance = new DataRepository();
                }
            }
        }
        return sInstance;
    }

    public List<SampleData> getDatas() {
        List<SampleData> dataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            SampleData data = new SampleData();
            data.setId(i);
            data.setData("test" + i);
            dataList.add(data);
        }
        return dataList;
    }

    public List<ColorData> getColorData() {
        List<ColorData> colors = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            colors.add(0, new ColorData(randomColor(), colors.size()));
        }

        return colors;
    }

    public List<Store> getStoreData(){
        List<Store> stores = new ArrayList<>();
        stores.add(new Store("台北車站門市","02-11112222"));
        stores.add(new Store("板橋車站門市","02-11113333"));
        stores.add(new Store("松山車站門市","02-22223333"));
        return stores;
    }

    public List<City> getAllCity(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("AllData.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (json == null) {
            return null;
        }
        return new Gson().fromJson(json, new TypeToken<List<City>>() {
        }.getType());
    }

    private static int randomColor() {
        int r = RANDOM.nextInt(256);
        int g = RANDOM.nextInt(256);
        int b = RANDOM.nextInt(256);

        return Color.rgb(r, g, b);
    }

    public Flowable<ApiResult> getMarkets(String scope, String rid, int offset, int limit) {
        return RestClient.getInstance().getDataService()
                .getData(scope, rid, offset, limit)
                .map(DataResult::getResult);
    }
}
