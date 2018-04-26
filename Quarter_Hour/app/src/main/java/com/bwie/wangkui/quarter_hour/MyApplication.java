package com.bwie.wangkui.quarter_hour;

import android.app.Application;


import com.facebook.drawee.backends.pipeline.Fresco;

import retrofit2.http.HEAD;


/**
 * Created by dell on 2018/4/24.
 */

public class MyApplication extends Application{

    public static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        Fresco.initialize(this);


        //网络请求封装初始化
//        RxRetrofitApp.init(this);

        Fresco.initialize(this);


    }

    public static MyApplication getMyApplication(){

        return myApplication;
    }
}
