package com.bwie.wangkui.quarter_hour.user.model;

import com.bwie.wangkui.quarter_hour.user.model.bean.FocusBean;
import com.bwie.wangkui.quarter_hour.utils.API;
import com.bwie.wangkui.quarter_hour.utils.ApiService;
import com.bwie.wangkui.quarter_hour.utils.RetrofitUtlis;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/4/27.
 */

public class FocusModel {

    public void focus_model(String uid, final focuslistenner focuslistenner){

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("uid",uid);

        RetrofitUtlis.getInstance(API.BASEURL)
                .getApiService(ApiService.class)
                .focus(hashMap)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<FocusBean>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(FocusBean focusBean) {

                        if (focuslistenner!=null){
                            focuslistenner.focusSuccess(focusBean);
                        }

                    }

                    @Override
                    public void onError(Throwable t) {

                        if (focuslistenner!=null){
                            focuslistenner.focesFail(t.getMessage());
                        }

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    public interface focuslistenner{

        void focesFail(String s);

        void focusSuccess(FocusBean focusBean);

    }
}
