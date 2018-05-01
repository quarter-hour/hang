package com.bwie.wangkui.quarter_hour.jokes.model;

import android.util.Log;

import com.bwie.wangkui.quarter_hour.jokes.model.bean.DuanZi;
import com.bwie.wangkui.quarter_hour.recommend.recommend_model.ReMen_Bean;
import com.bwie.wangkui.quarter_hour.recommend.recommend_model.ReMen_Model;
import com.bwie.wangkui.quarter_hour.utils.API;
import com.bwie.wangkui.quarter_hour.utils.ApiService;
import com.bwie.wangkui.quarter_hour.utils.RetrofitUtlis;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * Created by DELL on 2018/5/1.
 */

public class Duanzi_Model {

    public void getServer( String page,String uid, final CallBackDate callBackDate){
        ApiService apiService = RetrofitUtlis.getInstance(API.BASEURL).getApiService(ApiService.class);
        Flowable<DuanZi> jokes = apiService.getJokes(page,uid);
        jokes.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<DuanZi>() {
                    @Override
                    public void onNext(DuanZi duanZi) {
                        callBackDate.success(duanZi);
                    }

                    @Override
                    public void onError(Throwable t) {
                        callBackDate.faliure(t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public interface CallBackDate{
        void faliure(String s);
        void success(DuanZi duanZi);
    }

}
