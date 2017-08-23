package com.demo.epxoysample.api.datamodels;

import java.util.List;

/**
 * Created by chiu on 2017/8/22.
 */

public class ApiResult {
    private int offset;
    private int limit;
    private int count;
    private String sort;
    private List<Market> results;

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getCount() {
        return count;
    }

    public String getSort() {
        return sort;
    }

    public List<Market> getResults() {
        return results;
    }
}
