package com.demo.epxoysample.view;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.epoxy.ModelProp;
import com.airbnb.epoxy.ModelView;
import com.demo.epxoysample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Description View
 */
@ModelView(defaultLayout = R.layout.model_item_view)
public class ItemView extends LinearLayout {
    @BindView(R.id.txt_title)
    TextView mTxtTile;

    public ItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_item, this);
        ButterKnife.bind(this);
    }

    @ModelProp(options = ModelProp.Option.GenerateStringOverloads)
    public void setTitle(CharSequence title) {
        this.mTxtTile.setText(title);
    }

}
