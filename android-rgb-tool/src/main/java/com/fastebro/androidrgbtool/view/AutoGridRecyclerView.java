package com.fastebro.androidrgbtool.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by danielealtomare on 16/05/15.
 */
public class AutoGridRecyclerView extends RecyclerView {
    private GridLayoutManager layoutManager;
    private int columnWidth = -1;


    public AutoGridRecyclerView(Context context) {
        super(context);
        init(context, null);
    }


    public AutoGridRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }


    public AutoGridRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            int[] attrsArray = { android.R.attr.columnWidth };

            TypedArray array = context.obtainStyledAttributes(attrs, attrsArray);
            columnWidth = array.getDimensionPixelSize(0, -1);
            array.recycle();
        }

        layoutManager = new GridLayoutManager(getContext(), 2);
        setLayoutManager(layoutManager);
    }


    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);

        if (columnWidth > 0) {
            int spanCount = Math.max(1, getMeasuredWidth() / columnWidth);
            layoutManager.setSpanCount(spanCount);
        }
    }
}