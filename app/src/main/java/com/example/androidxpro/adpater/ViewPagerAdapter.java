package com.example.androidxpro.adpater;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.ListFragment;

import com.example.basicpro.base.BaseFragment;
import com.example.basicpro.base.BaseLazyFragment;
import com.example.basicpro.base.BaseNoModelFragment;

import java.util.List;

/**
 * author : 李文星
 * e-mail : 15168881989@163.com
 * date   : 2019-12-1913:53
 * desc   :
 * version: 1.0
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    List<BaseNoModelFragment> fragments;

    public ViewPagerAdapter(@NonNull FragmentManager fm,List<BaseNoModelFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
