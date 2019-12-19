package com.example.androidxpro.base;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.androidxpro.R;
import com.example.androidxpro.databinding.ToolbarLayoutBinding;

public abstract class BasicActivity<T extends ViewDataBinding> extends AppCompatActivity {

    public T binding;
    private ToolbarLayoutBinding toolbar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutResID = initView(savedInstanceState);
        super.setContentView(R.layout.activity_base);
        if (layoutResID != 0) {
            setContentView(layoutResID);
        }
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        binding = DataBindingUtil.inflate(getLayoutInflater(), layoutResID, (ViewGroup) findViewById(R.id.fly_com), true);
        toolbar = DataBindingUtil.bind(findViewById(R.id.toolbar_base));
        initActionBar();
        initData();
    }

    //
    protected ToolbarLayoutBinding getToolbar() {
        return toolbar;
    }

    protected abstract int initView(Bundle savedInstanceState);

    protected abstract void initActionBar();

    protected abstract void initData();

}
