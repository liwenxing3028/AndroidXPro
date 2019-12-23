package com.example.androidxpro.api;

import com.example.basicpro.retrofit.BaseApi;

import okhttp3.OkHttpClient;

/**
 * author : 李文星
 * e-mail : 15168881989@163.com
 * date   : 2019-12-2315:27
 * desc   :
 * version: 1.0
 */
public class Api extends BaseApi {

    /**
     * 静态内部类单例
     */
    private static class ApiHolder {
        private static Api api = new Api();
        private final static ApiService apiService = api.initRetrofit(ApiService.BASE_URL)
                .create(ApiService.class);
    }

    public static ApiService getInstance() {
        return ApiHolder.apiService;
    }

    @Override
    protected OkHttpClient setClient() {
        return null;
    }
}
