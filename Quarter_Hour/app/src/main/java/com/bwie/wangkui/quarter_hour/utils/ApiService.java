package com.bwie.wangkui.quarter_hour.utils;

import com.bwie.wangkui.quarter_hour.creation.model.PushBean;
import com.bwie.wangkui.quarter_hour.user.model.bean.Login_Bean;
import com.bwie.wangkui.quarter_hour.video.bean.ShowVideo_Bean;

import okhttp3.MultipartBody;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;


import com.bwie.wangkui.quarter_hour.video.bean.ShowVideo_Bean;
import com.bwie.wangkui.quarter_hour.video.bean.VicinityBean;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ThinkPad on 2018/4/24.
 */

public interface ApiService {

        @GET("quarter/getHotVideos")
        Flowable<ShowVideo_Bean> show_video(@QueryMap HashMap<String,String> map);
        //广告接口
        @GET("quarter/getAd")
        Observable<Bean> get();
        //发表段子

        @Multipart
        @POST("quarter/publishJoke")
        Flowable<PushBean> push(@QueryMap HashMap<String,String> map, @Part List<MultipartBody.Part> listParts);



    //热门视频

    //附近视频
    @GET("quarter/getHotVideos")
    Flowable<VicinityBean> vicinity(@QueryMap HashMap<String,String> map);

        //登录
        @GET("user/login")
        Flowable<Login_Bean> getLogin(@Query("mobile") String mobile, @Query("password") String password);

   /* //广告接口

    @GET("quarter/getAd")
    Observable<Bean> get();*/


    /**
     * 段子页面 方法
     */
   //获取段子列表
//    @GET("quarter/getJokes ")
//    Observable<> getlokelist(@Query("page") String page);
}
