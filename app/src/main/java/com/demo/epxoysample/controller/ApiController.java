package com.demo.epxoysample.controller;

import com.airbnb.epoxy.AutoModel;
import com.airbnb.epoxy.EpoxyController;
import com.demo.epxoysample.api.datamodels.Market;
import com.demo.epxoysample.viewholders.MarketModel_;
import com.demo.epxoysample.view.FooterViewModel_;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chiu on 2017/8/22.
 */

public class ApiController extends EpoxyController {//Typed2EpoxyController<List<Market>, Boolean> {
    @AutoModel
    FooterViewModel_ mFooterViewModel_;
    private List<Market> mMarkets = new ArrayList<>();
    private boolean loadingMore;

    public void setLoadingMore(boolean loadingMore) {
        this.loadingMore = loadingMore;
        requestModelBuild();
    }

    public void addMarkets(List<Market> photos) {
        this.mMarkets.addAll(photos);
        requestModelBuild();
    }

//    @Override
//    protected void buildModels(List<Market> data1, Boolean data2) {
//        for (Market market :
//                data1) {
//            new MarketModel_()
//                    .id(market.get_id())
//                    .title(market.getStitle())
//                    .body(market.getXbody())
//                    .createDate(market.getXcreatedDate())
//                    .address(market.getxAddress())
//                    .addTo(this);
//        }
//        mFooterViewModel_.addIf(loadingMore, this);
//    }

    @Override
    protected void buildModels() {
        for (Market market : mMarkets) {
            new MarketModel_()
                    .id(market.hashCode())
                    .title(market.getStitle())
                    .body(market.getXbody())
                    .createDate(market.getXcreatedDate())
                    .address(market.getxAddress())
                    .addTo(this);
        }
        mFooterViewModel_.addIf(loadingMore, this);
    }
}
