package com.bwie.wangkui.quarter_hour.utils;

import com.bwie.wangkui.quarter_hour.video.bean.ShowVideo_Bean;

import retrofit2.http.GET;


import com.bwie.wangkui.quarter_hour.video.bean.ShowVideo_Bean;

import java.util.HashMap;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ThinkPad on 2018/4/24.
 */

public interface ApiService {
<<<<<<< HEAD

        @GET("quarter/getHotVideos")
        Flowable<ShowVideo_Bean> show_video(@QueryMap HashMap<String,String> map);
=======
    //广告接口
>>>>>>> 9f42f2314ab1b5de01d6d7158a8b403eff5f2e55
    @GET("quarter/getAd")
    Observable<Bean> get();


    /**
     * 段子页面 方法
     */
   //获取段子列表
//    @GET("quarter/getJokes ")
//    Observable<> getlokelist(@Query("page") String page);
}
