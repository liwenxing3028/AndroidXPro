package com.example.androidxpro.bean.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.example.androidxpro.R;
import com.example.androidxpro.api.Api;
import com.example.androidxpro.bean.NewsBean;
import com.example.basicpro.lifecycle.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * author : 李文星
 * e-mail : 15168881989@163.com
 * date   : 2019-12-2316:41
 * desc   :
 * version: 1.0
 */
public class NewsViewModel extends BaseViewModel {


    protected MutableLiveData<NewsBean> news = new MutableLiveData<>();

    public void requestData() {
        showDialog.setValue(true, "加载中");

        Disposable disposable = Api.getInstance().news()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(newsBean -> {
                    showDialog.setValue(false);
                    news.setValue(newsBean);
                }, throwable -> {
                    showDialog.setValue(false);
                    error.setValue("发生错误了");
                });
        addDisposable(disposable);
    }

    public MutableLiveData<NewsBean> getNews() {
        return news;
    }

    public List getMDrawableList() {
        MutableLiveData<List<Integer>> images = new MutableLiveData<>();
        List<Integer> image = new ArrayList<>();
        image.add(R.mipmap.t0);
        image.add(R.mipmap.t1);
        images.setValue(image);
        return image;
    }
}
