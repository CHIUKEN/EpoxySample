package com.demo.epxoysample.controller;

import com.airbnb.epoxy.AutoModel;
import com.airbnb.epoxy.EpoxyController;
import com.demo.epxoysample.api.datamodels.ColorData;
import com.demo.epxoysample.api.datamodels.Store;
import com.demo.epxoysample.view.BannerViewModel_;
import com.demo.epxoysample.view.GroupItemView;
import com.demo.epxoysample.view.HtmlViewModel_;
import com.demo.epxoysample.view.ItemViewModel_;

import java.util.List;

/**
 * Created by chiu on 2017/8/18.
 */

public class ScrollViewController extends EpoxyController {
    private List<Store> mStores;
    @AutoModel
    BannerViewModel_ mBannerViewModel_;
    @AutoModel
    ItemViewModel_ mItemViewModel_1;
    @AutoModel
    ItemViewModel_ mItemViewModel_2;
    @AutoModel
    HtmlViewModel_ mHtmlViewModel_;
    GroupItemView.PhoneCallBack mCallBack;

    public ScrollViewController(List<Store> stores, GroupItemView.PhoneCallBack callBack) {
        mStores = stores;
        this.mCallBack = callBack;
    }

    @Override
    protected void buildModels() {
        mBannerViewModel_
                .addTo(this);

        mItemViewModel_1
                .title("This is description1")
                .addTo(this);
        mItemViewModel_2
                .title("This is description2")
                .addTo(this);

        mHtmlViewModel_.content("<H1>Test</H1><H2>Test</H2><H3>Test</H3><H4>Test</H4><H5>Test</H5>")
                .addTo(this);

        add(new GroupItemView(mStores, mCallBack));
    }
}
