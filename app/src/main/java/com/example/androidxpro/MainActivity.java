package com.example.androidxpro;

import android.view.MenuItem;

import androidx.viewpager.widget.ViewPager;

import com.example.androidxpro.adpater.ViewPagerAdapter;
import com.example.androidxpro.databinding.ActivityMainBinding;

import com.example.androidxpro.fragment.ControlFragment;
import com.example.androidxpro.fragment.MainFragment;

import com.example.androidxpro.fragment.PersonFragment;
import com.example.basicpro.base.BaseFragment;
import com.example.basicpro.base.BaseLazyFragment;
import com.example.basicpro.base.BaseNoModelActivity;
import com.example.basicpro.base.BaseNoModelFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseNoModelActivity<ActivityMainBinding> {

    @Override
    protected int onCreate() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        List<BaseNoModelFragment> fragments = new ArrayList<>();
        fragments.add(new MainFragment());
        fragments.add(new ControlFragment());
        fragments.add(new PersonFragment());
        dataBinding.viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),fragments));
    }

    @Override
    protected void initData() {

        dataBinding.toolbarBase.tvName.setText("天青色等烟雨,而我在等你❤");
        dataBinding.navgiLayout.bnvMenu.setOnNavigationItemSelectedListener(item -> {
            String title = item.getTitle().toString();
            switch (item.getItemId()) {
                case R.id.item_bottom_1:
                    dataBinding.viewPager.setCurrentItem(0,false);
                    break;
                case R.id.item_bottom_2:
                    dataBinding.viewPager.setCurrentItem(1,false);
                    break;
                case R.id.item_bottom_3:
                    dataBinding.viewPager.setCurrentItem(2,false);
                    break;
                default:
                    break;
            }
            return true;
        });
    }
}
