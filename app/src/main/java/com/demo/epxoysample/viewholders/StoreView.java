package com.demo.epxoysample.viewholders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.airbnb.epoxy.ModelProp;
import com.airbnb.epoxy.ModelView;
import com.demo.epxoysample.R;
import com.demo.epxoysample.view.BaseEpoxyHolder;
import com.demo.epxoysample.view.GroupItemView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by chiu on 2017/8/22.
 */
@ModelView(defaultLayout = R.layout.model_store_view)
public class StoreView extends FrameLayout {
    @BindView(R.id.txt_store_name)
    TextView mTxtStoreName;
    @BindView(R.id.txt_phone)
    TextView mTxtPhone;
    @BindView(R.id.img_call)
    ImageView mImageCall;

    public StoreView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_store, this);
        ButterKnife.bind(this);
    }

    @ModelProp
    public void setPhone(String phone){
        mImageCall.setTag(phone);
        mTxtPhone.setText(phone);
    }

    @ModelProp
    public void setStoreName(String storeName){
        mTxtStoreName.setText(storeName);
    }

    @ModelProp(options = { ModelProp.Option.DoNotHash})
    public void setOnClick(@Nullable  OnClickListener listener){
        mImageCall.setOnClickListener(listener);
    }

//    @ModelProp(options = ModelProp.Option.IgnoreRequireHashCode)
//    public void setObject(GroupItemView.PhoneCallBack callBack) {
//        callBack.onPhoneCall(mTxtPhone.getText().toString());
//    }

}
