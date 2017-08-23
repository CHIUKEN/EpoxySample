package com.demo.epxoysample.view;


import android.view.View;

import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.EpoxyModelGroup;
import com.airbnb.epoxy.OnModelClickListener;
import com.demo.epxoysample.R;
import com.demo.epxoysample.api.datamodels.Store;
import com.demo.epxoysample.viewholders.StoreView;
import com.demo.epxoysample.viewholders.StoreViewModel_;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chiu on 2017/8/19.
 */
public class GroupItemView extends EpoxyModelGroup {
    public interface PhoneCallBack {
        void onPhoneCall(String phone);
    }

    public GroupItemView(List<Store> stores, PhoneCallBack callBack) {
        super(R.layout.model_group_item_view, buildModels(stores, callBack));
    }

    private static List<EpoxyModel<?>> buildModels(List<Store> stores, PhoneCallBack callBack) {
        ArrayList<EpoxyModel<?>> models = new ArrayList<>();
        for (int i = 0; i < stores.size(); i++) {
            models.add(new StoreViewModel_()
                    .id(stores.get(i).hashCode())
                    .phone(stores.get(i).getPhone())
                    .storeName(stores.get(i).getStoreName())
                    .onClick(view -> {
                        callBack.onPhoneCall((String) view.getTag());
                    }));
        }
        return models;
    }
}
