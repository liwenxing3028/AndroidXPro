package com.example.androidxpro.adpater;


import android.graphics.Movie;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.androidxpro.R;
import com.example.androidxpro.bean.NewsBean;
import com.example.androidxpro.databinding.ItemNesBinding;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * author : 李文星
 * e-mail : 15168881989@163.com
 * date   : 2019-12-2315:58
 * desc   :
 * version: 1.0
 */
public class NewsAdapter extends BaseQuickAdapter<NewsBean.StoriesBean, BaseViewHolder> {


    public NewsAdapter() {
        super(R.layout.item_nes);
    }

    @Override
    protected void onItemViewHolderCreated(@NotNull BaseViewHolder viewHolder, int viewType) {
        // 绑定 view
        DataBindingUtil.bind(viewHolder.itemView);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, @Nullable NewsBean.StoriesBean storiesBean) {

        if (storiesBean == null) {
            return;
        }

       ItemNesBinding binding = baseViewHolder.getBinding();

        if (binding != null) {
            // 设置数据
            binding.setBean(storiesBean);
            binding.executePendingBindings();
        }
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }
}
