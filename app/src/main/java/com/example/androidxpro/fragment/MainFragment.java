package com.example.androidxpro.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidxpro.R;
import com.example.androidxpro.databinding.FragmentMainBinding;
import com.example.androidxpro.databinding.FragmentMainBindingImpl;
import com.example.basicpro.base.BaseFragment;
import com.example.basicpro.base.BaseLazyFragment;
import com.example.basicpro.base.BaseNoModelFragment;
import com.example.basicpro.lifecycle.BaseViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseNoModelFragment<FragmentMainBinding> {

    //页面的数据可以写在这里
    public String data = "注册登录等一等";
    @Override
    protected int onCreate() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        dataBinding.setMain(this);
    }

}
