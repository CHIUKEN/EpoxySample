package com.demo.epxoysample.listeners;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by USER on 2016/2/19.
 */
public abstract class EndlessRecyclerOnScrollListener extends RecyclerView.OnScrollListener{
    public static String TAG = EndlessRecyclerOnScrollListener.class.getSimpleName();
    private int current_page = 1;
    private LinearLayoutManager mLinearLayoutManager;
    private static final int DEFAULT_LOADING_TRIGGER_OFFSET_SIZE = 5;


    public EndlessRecyclerOnScrollListener(LinearLayoutManager linearLayoutManager) {
        this.mLinearLayoutManager = linearLayoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if (dy > 0) {
            checkNextLoad(mLinearLayoutManager);
        }
    }

    public void checkNextLoad(@NonNull LinearLayoutManager manager) {

        if (shouldLoadNext(manager)) {

            current_page++;
            onLoadMore(current_page);

        }
    }


    public boolean shouldLoadNext(@NonNull LinearLayoutManager manager) {
        int lastItemPosition = manager.getItemCount() - 1;
        int lastVisibleItemPositions = manager.findLastVisibleItemPosition();

        return (lastItemPosition < lastVisibleItemPositions + getLoadingTriggerOffsetSize());
    }


    public int getLoadingTriggerOffsetSize() {
        return DEFAULT_LOADING_TRIGGER_OFFSET_SIZE;
    }

    public abstract void onLoadMore(int current_page);
}
