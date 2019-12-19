package com.example.androidxpro.fragment;


import androidx.fragment.app.Fragment;

import com.example.androidxpro.R;
import com.example.androidxpro.databinding.FragmentPersonBinding;
import com.example.basicpro.base.BaseNoModelFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonFragment extends BaseNoModelFragment<FragmentPersonBinding> {

    //页面的数据可以写在这里
    public String data = "炊烟袅袅升起，隔江千万里";
    @Override
    protected int onCreate() {
        return R.layout.fragment_person;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        dataBinding.setPerson(this);
        dataBinding.setLifecycleOwner(this);
    }

}
