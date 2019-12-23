package com.example.androidxpro.fragment;


import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidxpro.R;
import com.example.androidxpro.adpater.NewsAdapter;
import com.example.androidxpro.bean.NewsBean;
import com.example.androidxpro.bean.viewmodel.NewsViewModel;
import com.example.androidxpro.databinding.FragmentMainBinding;
import com.example.androidxpro.view.banner.ImageResourceViewHolder;
import com.example.basicpro.base.BaseFragment;
import com.example.basicpro.base.BaseLazyFragment;
import com.example.basicpro.base.BaseNoModelFragment;
import com.example.basicpro.lifecycle.BaseViewModel;
import com.example.basicpro.utils.ToastUtils;
import com.zhpan.bannerview.constants.IndicatorSlideMode;
import com.zhpan.bannerview.constants.PageStyle;
import com.zhpan.bannerview.constants.TransformerStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseNoModelFragment<FragmentMainBinding> {

    private NewsAdapter adapter;
    private NewsViewModel viewModel;

    @Override
    protected int onCreate() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {
        dataBinding.setMain(this);

        viewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        viewModel.requestData();
        //数据请求成功通知
        viewModel.getNews().observe(this,
                newsBean -> adapter.setNewData(newsBean.getStories()));
    }

    @Override
    protected void initData() {
        dataBinding.bannerView
                .setIndicatorSlideMode(IndicatorSlideMode.SMOOTH)
                .setHolderCreator(() -> new ImageResourceViewHolder(5))
                .setIndicatorColor(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.colorPrimary))
                .setPageTransformerStyle(TransformerStyle.STACK)
                .setOnPageClickListener(position -> ToastUtils.show("position:" + position))
                .setInterval(5000)
                .create(viewModel.getMDrawableList());
        RecyclerView rvNews = dataBinding.rvMain;
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        adapter = new NewsAdapter();
        rvNews.setLayoutManager(manager);
        rvNews.setAdapter(adapter);
    }

}
