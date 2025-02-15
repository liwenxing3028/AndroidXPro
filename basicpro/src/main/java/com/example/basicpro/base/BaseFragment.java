package com.example.basicpro.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;

import com.example.basicpro.bean.DialogBean;
import com.example.basicpro.lifecycle.BaseViewModel;


public abstract class BaseFragment<VM extends BaseViewModel, DB extends ViewDataBinding>
        extends BaseNoModelFragment<DB> {

    protected VM viewModel;

    @Override
    protected DB initDataBinding(LayoutInflater inflater, int layoutId, ViewGroup container) {
        DB db = super.initDataBinding(inflater, layoutId, container);
        /**
         * 将这两个初始化函数插在{@link BaseFragment#initDataBinding}
         */
        viewModel = initViewModel();
        initObserve();
        return db;
    }

    /**
     * 初始化ViewModel
     */
    protected abstract VM initViewModel();

    /**
     * 监听当前ViewModel中 showDialog和error的值
     */
    private void initObserve() {
        if (viewModel == null) return;
        viewModel.getShowDialog(this, bean -> {
            if (bean.isShow()) {
                showDialog(bean.getMsg());
            } else {
                dismissDialog();
            }
        });
        viewModel.getError(this, obj -> showError(obj));
    }

    /**
     * ViewModel层发生了错误
     */
    protected abstract void showError(Object obj);
}
