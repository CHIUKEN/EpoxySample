package com.demo.epxoysample.api;

import com.demo.epxoysample.api.services.DataService;
import com.github.simonpercic.oklog3.OkLogInterceptor;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by chiu on 2017/8/18.
 */

public class RestClient {
    private static volatile RestClient sInstance;
    private DataService mDataService;

    public static RestClient getInstance() {
        if (sInstance == null) {
            synchronized (RestClient.class) {
                if (sInstance == null) {
                    sInstance = new RestClient();
                }
            }
        }
        return sInstance;
    }

    private RestClient() {
        Gson gson = new Gson();
        String baseUrl = "http://data.taipei/";
        mDataService = createService(DataService.class, baseUrl, gson);
    }

    private static <S> S createService(Class<S> serviceClass, String baseUrl, Gson gson) {
        //http log
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        // create an instance of OkLogInterceptor using a builder()
        OkLogInterceptor okLogInterceptor = OkLogInterceptor.builder().build();

        OkHttpClient client = new OkHttpClient().newBuilder()
                .addInterceptor(logging)
                .addInterceptor(okLogInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))//gson 解析
                .addConverterFactory(ScalarsConverterFactory.create())// string
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//使用rxjava
                .client(client)
                .build();

        return retrofit.create(serviceClass);
    }

    public DataService getDataService() {
        return mDataService;
    }
}
