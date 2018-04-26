package com.bwie.wangkui.quarter_hour;

import android.app.Application;
import android.content.SharedPreferences;


import com.facebook.drawee.backends.pipeline.Fresco;

import retrofit2.http.HEAD;


/**
 * Created by dell on 2018/4/24.
 */

public class MyApplication extends Application{

    public static MyApplication myApplication;
    private static SharedPreferences userinfo;


    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        Fresco.initialize(this);


        //网络请求封装初始化
//        RxRetrofitApp.init(this);

        Fresco.initialize(this);
        userinfo = getSharedPreferences("userinfo", MODE_PRIVATE);


    }

    public static MyApplication getMyApplication(){

        return myApplication;
    }

    public static SharedPreferences getSp(){
        if(userinfo!=null) {
            return userinfo;
        }
        return null;
    }
}
