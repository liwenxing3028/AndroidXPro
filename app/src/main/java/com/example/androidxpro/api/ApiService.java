package com.example.androidxpro.api;

import com.example.androidxpro.bean.NewsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * author : 李文星
 * e-mail : 15168881989@163.com
 * date   : 2019-12-2315:27
 * desc   :
 * version: 1.0
 */
public interface ApiService {
    String BASE_URL = "https://news-at.zhihu.com/api/4/";

    /**
     * 测试接口
     */
    @GET("news/latest")
    Observable<NewsBean> news();
}
