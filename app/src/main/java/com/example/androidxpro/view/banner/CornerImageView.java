package com.example.androidxpro.view.banner;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

import com.example.basicpro.utils.DensityUtil;

/**
 * author : 李文星
 * e-mail : 15168881989@163.com
 * date   : 2019-12-2309:57
 * desc   :
 * version: 1.0
 */
public class CornerImageView extends AppCompatImageView
{

    private float radius;

    public CornerImageView(Context context) {
        super(context);

        init();
    }

    public CornerImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public CornerImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CornerImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        setRadius(DensityUtil.dip2px(getContext(),5));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Path clipPath = new Path();
        RectF rect = new RectF(0, 0, this.getWidth(), this.getHeight());
        clipPath.addRoundRect(rect, radius, radius, Path.Direction.CW);
        canvas.clipPath(clipPath);
        super.onDraw(canvas);
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}