package com.demo.epxoysample.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;

/**
 * Created by chiu on 2017/8/18.
 */

public class BannerAdapter extends StaticPagerAdapter {
    private String[] mUrls;

    public BannerAdapter() {
        mUrls = new String[]{"https://cdn.pixabay.com/photo/2016/08/31/14/49/doraemon-1633723_640.jpg",
                "https://cdn.pixabay.com/photo/2016/09/29/14/21/doraemon-1702944_640.jpg", "" +
                "https://cdn.pixabay.com/photo/2016/08/31/14/49/doraemon-1633720_640.jpg"};
    }

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView view = new ImageView(container.getContext());
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        Glide.with(container.getContext())
                .load(mUrls[position])
                .into(view);
        return view;
    }

    @Override
    public int getCount() {
        return mUrls.length;
    }
}
