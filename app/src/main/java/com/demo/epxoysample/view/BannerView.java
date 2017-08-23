package com.demo.epxoysample.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.airbnb.epoxy.ModelView;
import com.demo.epxoysample.R;
import com.demo.epxoysample.adapters.BannerAdapter;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Banner View
 */
@ModelView(defaultLayout = R.layout.model_banner_view)
public class BannerView extends FrameLayout {
    @BindView(R.id.rollPagerView)
    RollPagerView mRollPagerView;

    public BannerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_banner, this);
        ButterKnife.bind(this);
        setUpRollPagerView();
    }

    private void setUpRollPagerView(){
        BannerAdapter adapter = new BannerAdapter();
        mRollPagerView.setAdapter(adapter);
        mRollPagerView.setHintView(new ColorPointHintView(getContext(), Color.YELLOW, Color.WHITE));
    }
}
