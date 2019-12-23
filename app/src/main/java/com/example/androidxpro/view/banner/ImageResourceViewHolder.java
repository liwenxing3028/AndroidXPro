package com.example.androidxpro.view.banner;

import android.view.View;

import com.example.androidxpro.R;
import com.zhpan.bannerview.holder.ViewHolder;

/**
 * author : 李文星
 * e-mail : 15168881989@163.com
 * date   : 2019-12-2309:39
 * desc   :
 * version: 1.0
 */
public class ImageResourceViewHolder implements ViewHolder<Integer> {

    private int roundCorner;

    public ImageResourceViewHolder(int roundCorner) {
        this.roundCorner = roundCorner;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_slide_mode;
    }

    @Override
    public void onBind(View itemView, Integer data, int position, int size) {
        CornerImageView imageView = itemView.findViewById(R.id.banner_image);
        imageView.setImageResource(data);
        //imageView.setRoundCorner(roundCorner);
    }

}