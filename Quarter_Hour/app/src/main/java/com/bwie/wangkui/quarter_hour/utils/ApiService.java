package com.bwie.wangkui.quarter_hour.utils;

import com.bwie.wangkui.quarter_hour.recommend.recommend_model.ReMen_Bean;
import com.bwie.wangkui.quarter_hour.video.bean.ShowVideo_Bean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

import java.util.HashMap;


import retrofit2.http.QueryMap;

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

    //获取视频作品列表
    @GET("quarter/getVideos")
    Flowable<ReMen_Bean> getRM(@Query("page") String page);

}
