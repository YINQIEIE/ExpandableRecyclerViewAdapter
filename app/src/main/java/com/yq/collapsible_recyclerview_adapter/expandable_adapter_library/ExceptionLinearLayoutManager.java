package com.yq.collapsible_recyclerview_adapter.expandable_adapter_library;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2018/2/26.
 * avoid the exception occurs when adapter's data changes fast and frequently
 * 当数据集大小来回快速变化时经常会抛出 IndexOutOfBoundsException
 */

public class ExceptionLinearLayoutManager extends LinearLayoutManager {

    public ExceptionLinearLayoutManager(Context context) {
        super(context);
    }

    public ExceptionLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public ExceptionLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
