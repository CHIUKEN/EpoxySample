package com.demo.epxoysample.api.services;

import com.demo.epxoysample.api.datamodels.DataResult;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by chiu on 2017/8/22.
 */

public interface DataService {
    @GET("/opendata/datalist/apiAccess/")
    Flowable<DataResult> getData(@Query("scope") String scope, @Query("rid") String rid, @Query("offset") int offset, @Query("limit") int limit);
}
