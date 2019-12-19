package com.example.androidxpro.fragment;


import androidx.fragment.app.Fragment;

import com.example.androidxpro.R;
import com.example.androidxpro.databinding.FragmentControlBinding;
import com.example.basicpro.base.BaseNoModelFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ControlFragment extends BaseNoModelFragment<FragmentControlBinding> {


    //页面的数据可以写在这里
    public String data = "大江东去，浪淘尽，千古风流人物";

    @Override
    protected int onCreate() {
        return R.layout.fragment_control;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        dataBinding.setControl(this);
    }
}
