package com.example.basicpro.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public abstract class BaseApi {

    /**
     * 初始化Retrofit
     */
    public Retrofit initRetrofit(String baseUrl) {
        Retrofit.Builder builder = new Retrofit.Builder();
        //支持返回Call<String>
        builder.addConverterFactory(ScalarsConverterFactory.create());
        //支持直接格式化json返回Bean对象
        builder.addConverterFactory(GsonConverterFactory.create());
        //支持RxJava
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        builder.baseUrl(baseUrl);
        OkHttpClient client = setClient();
        if (client != null) {
            builder.client(client);
        }
        return builder.build();
    }

    /**
     * 设置OkHttpClient，添加拦截器等
     *
     * @return 可以返回为null
     */
    protected abstract OkHttpClient setClient();
}
