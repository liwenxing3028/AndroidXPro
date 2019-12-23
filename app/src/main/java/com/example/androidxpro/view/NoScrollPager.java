package com.example.androidxpro.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/**
 * author : 李文星
 * e-mail : 15168881989@163.com
 * date   : 2019-12-1914:10
 * desc   : 没有滑动
 * version: 1.0¬
 */
public class NoScrollPager extends ViewPager {

    public NoScrollPager(@NonNull Context context) {
        super(context);
    }

    public NoScrollPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}
