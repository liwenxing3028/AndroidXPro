package com.example.androidxpro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

import com.example.androidxpro.base.BasicActivity;
import com.example.androidxpro.databinding.ActivityMainBinding;

public class MainActivity extends BasicActivity<ActivityMainBinding> {

    @Override
    protected int initView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    protected void initActionBar() {
        getToolbar().tvName.setText("天青色等烟雨");
    }

    @Override
    protected void initData() {
        binding.tabMode.setText("而我在等你！❤");
    }

}
