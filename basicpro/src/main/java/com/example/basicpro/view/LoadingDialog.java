package com.example.basicpro.view;


import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.example.basicpro.R;
import com.example.basicpro.databinding.DialogLoadingBinding;
import com.example.basicpro.utils.DensityUtil;

public class LoadingDialog extends Dialog {

    private DialogLoadingBinding binding;


    public LoadingDialog(@NonNull Context context) {
        super(context, R.style.LoadingDialog);
        setCanceledOnTouchOutside(false);
        binding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.dialog_loading, null, false);
        setContentView(binding.getRoot());
        Window window = getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = DensityUtil.dip2px(context, 150);
        lp.height = DensityUtil.dip2px(context, 110);
        lp.gravity = Gravity.CENTER;
        window.setAttributes(lp);
    }

    /**
     * 设置等待提示信息
     */
    public void setLoadingMsg(String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        binding.tvMsg.setText(msg);
    }
}
