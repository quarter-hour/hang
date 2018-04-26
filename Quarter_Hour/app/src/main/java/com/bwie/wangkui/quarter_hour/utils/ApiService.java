package com.bwie.wangkui.quarter_hour.utils;

import com.bwie.wangkui.quarter_hour.user.model.bean.Login_Bean;
import com.bwie.wangkui.quarter_hour.video.bean.ShowVideo_Bean;

import retrofit2.http.GET;


import com.bwie.wangkui.quarter_hour.video.bean.ShowVideo_Bean;
import com.bwie.wangkui.quarter_hour.video.bean.VicinityBean;

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
    //热门视频
    @GET("quarter/getHotVideos")
    Flowable<ShowVideo_Bean> show_video(@QueryMap HashMap<String,String> map);
    //附近视频
    @GET("quarter/getHotVideos")
    Flowable<VicinityBean> vicinity(@QueryMap HashMap<String,String> map);
=======

        @GET("quarter/getHotVideos")
        Flowable<ShowVideo_Bean> show_video(@QueryMap HashMap<String,String> map);
        //登录
        @GET("user/login")
        Flowable<Login_Bean> getLogin(@Query("mobile") String mobile, @Query("password") String password);

   /* //广告接口
// 9f42f2314ab1b5de01d6d7158a8b403eff5f2e55
>>>>>>> 31bd2277432b15d1e8c69e8f282ef95f4fca5818
    @GET("quarter/getAd")
    Observable<Bean> get();*/


    /**
     * 段子页面 方法
     */
   //获取段子列表
//    @GET("quarter/getJokes ")
//    Observable<> getlokelist(@Query("page") String page);
}
