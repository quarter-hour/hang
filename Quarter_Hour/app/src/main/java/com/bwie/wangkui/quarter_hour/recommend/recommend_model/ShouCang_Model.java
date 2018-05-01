package com.bwie.wangkui.quarter_hour.recommend.recommend_model;

import android.util.Log;

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

public class ShouCang_Model {

    public void getServer(String wid,String token, final CallBackDate callBackDate){
        ApiService apiService = RetrofitUtlis.getInstance(API.BASEURL).getApiService(ApiService.class);
        Flowable<ShouCang> shouCang = apiService.getShouCang(wid,token);
        shouCang.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DefaultSubscriber<ShouCang>() {
                    @Override
                    public void onNext(ShouCang shouCang) {
                        callBackDate.success(shouCang);
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
        void success(ShouCang shouCang);
    }


}
