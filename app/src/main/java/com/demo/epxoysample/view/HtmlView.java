package com.demo.epxoysample.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.FrameLayout;

import com.airbnb.epoxy.ModelProp;
import com.airbnb.epoxy.ModelView;
import com.demo.epxoysample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chiu on 2017/8/18.
 */
@ModelView(defaultLayout = R.layout.model_html_view)
public class HtmlView extends FrameLayout {
    @BindView(R.id.webView)
    WebView mWebView;

    public HtmlView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_html, this);
        ButterKnife.bind(this);
    }

    @ModelProp
    public void setContent(String content) {
        this.mWebView.loadDataWithBaseURL("", content, "html/text", "utf-8", "");
    }
}
