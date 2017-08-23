package com.demo.epxoysample.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.airbnb.epoxy.ModelView;
import com.demo.epxoysample.R;

import butterknife.ButterKnife;

/**
 * Created by chiu on 2017/8/22.
 */
@ModelView(defaultLayout = R.layout.model_footer_item_view)
public class FooterView extends FrameLayout {
    public FooterView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_footer_item, this);
        ButterKnife.bind(this);
    }
}
