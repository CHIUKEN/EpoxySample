package com.demo.epxoysample.viewholders;

import android.view.View;
import android.widget.TextView;

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
@EpoxyModelClass(layout = R.layout.model_sample_data_view)
public abstract class SampleDataModel extends EpoxyModelWithHolder<SampleDataModel.SampleDataItemHolder> {
    @EpoxyAttribute
    String comment;
    @EpoxyAttribute(DoNotHash)
    View.OnClickListener clickListener;

    @Override
    public void bind(SampleDataItemHolder holder) {
        holder.itemView.setOnClickListener(clickListener);
        holder.txtView.setText(comment);
    }

    @Override
    public void unbind(SampleDataItemHolder holder) {
        holder.itemView.setOnClickListener(null);
    }

    public static class SampleDataItemHolder extends BaseEpoxyHolder {
        @BindView(R.id.itemView)
        View itemView;
        @BindView(R.id.txt_view_name)
        TextView txtView;
    }
}
