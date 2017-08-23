package com.demo.epxoysample.viewholders;

import android.support.annotation.ColorInt;
import android.view.View;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.demo.epxoysample.R;
import com.demo.epxoysample.view.BaseEpoxyHolder;

import butterknife.BindView;

import static com.airbnb.epoxy.EpoxyAttribute.Option.DoNotHash;

/**
 * Created by chiu on 2017/8/18.
 */
@EpoxyModelClass(layout = R.layout.model_color)
public abstract class ColorModel extends EpoxyModelWithHolder<ColorModel.ColorHolder>{
    @EpoxyAttribute
    @ColorInt
    int color;
    @EpoxyAttribute(DoNotHash) View.OnClickListener clickListener;

    @Override
    public void bind(ColorHolder holder) {
        holder.cardView.setBackgroundColor(color);
        holder.cardView.setOnClickListener(clickListener);
    }

    @Override
    public void unbind(ColorHolder holder) {
        holder.cardView.setOnClickListener(null);
    }

    public static class ColorHolder extends BaseEpoxyHolder {
        @BindView(R.id.card_view)
        View cardView;
    }
}
