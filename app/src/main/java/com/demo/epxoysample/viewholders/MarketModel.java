package com.demo.epxoysample.viewholders;

import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.demo.epxoysample.R;
import com.demo.epxoysample.view.BaseEpoxyHolder;

import butterknife.BindView;

/**
 * Created by chiu on 2017/8/22.
 */
@EpoxyModelClass(layout = R.layout.view_market)
public abstract class MarketModel extends EpoxyModelWithHolder<MarketModel.MarketHolder> {
    @EpoxyAttribute
    String title;
    @EpoxyAttribute
    String body;
    @EpoxyAttribute
    String createDate;
    @EpoxyAttribute
    String address;

    @Override
    public void bind(MarketHolder holder) {
        holder.mTxtTitle.setText(title);
        holder.mTxtBody.setText(body);
        holder.mTxtCreateDate.setText(createDate);
        holder.mTxtAddress.setText(address);
    }

    public static class MarketHolder extends BaseEpoxyHolder {

        @BindView(R.id.txt_title)
        TextView mTxtTitle;
        @BindView(R.id.txt_body)
        TextView mTxtBody;
        @BindView(R.id.txt_create_date)
        TextView mTxtCreateDate;
        @BindView(R.id.txt_address)
        TextView mTxtAddress;
    }
}
