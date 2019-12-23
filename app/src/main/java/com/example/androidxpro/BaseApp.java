package com.example.androidxpro;

import android.app.Application;

import com.example.basicpro.utils.Utils;

/**
 * author : 李文星
 * e-mail : 15168881989@163.com
 * date   : 2019-12-2310:40
 * desc   :
 * version: 1.0
 */
public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);
    }
}
