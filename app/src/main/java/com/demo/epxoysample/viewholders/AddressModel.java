package com.demo.epxoysample.viewholders;

import android.support.annotation.ColorInt;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.demo.epxoysample.R;
import com.demo.epxoysample.view.BaseEpoxyHolder;

import butterknife.BindView;

/**
 * Created by chiu on 2017/8/21.
 */
@EpoxyModelClass(layout = R.layout.view_address)
public abstract class AddressModel extends EpoxyModelWithHolder<AddressModel.AddressViewHolder> {
    @EpoxyAttribute
    @ColorInt
    int color;
    @EpoxyAttribute
    String name;

    @Override
    public void bind(AddressViewHolder holder) {
        holder.mLayout.setBackgroundColor(color);
        holder.mTxtName.setText(name);
    }

    public static class AddressViewHolder extends BaseEpoxyHolder {
        @BindView(R.id.list_item)
        LinearLayout mLayout;
        @BindView(R.id.txt_name)
        TextView mTxtName;
    }
}
