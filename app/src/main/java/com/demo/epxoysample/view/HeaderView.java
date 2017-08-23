package com.demo.epxoysample.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.epoxy.ModelProp;
import com.airbnb.epoxy.ModelView;
import com.demo.epxoysample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chiu on 2017/8/18.
 */
@ModelView(defaultLayout = R.layout.model_header_view)
public class HeaderView extends LinearLayout {
    @BindView(R.id.title_text)
    TextView title;
    @BindView(R.id.caption_text)
    TextView caption;

    public HeaderView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setOrientation(VERTICAL);
        inflate(getContext(), R.layout.view_header, this);
        ButterKnife.bind(this);
    }

    @ModelProp(options = ModelProp.Option.GenerateStringOverloads)
    public void setTitle(CharSequence title) {
        this.title.setText(title);
    }

    @ModelProp(options = ModelProp.Option.GenerateStringOverloads)
    public void setCaption(CharSequence caption) {
        this.caption.setText(caption);
    }
}
