package com.bwie.wangkui.quarter_hour.utils;

<<<<<<< HEAD
import com.bwie.wangkui.quarter_hour.recommend.recommend_model.ReMen_Bean;
=======
import com.bwie.wangkui.quarter_hour.user.model.bean.Login_Bean;
<<<<<<< HEAD
import com.bwie.wangkui.quarter_hour.video.bean.Details_Bean;
=======
import com.bwie.wangkui.quarter_hour.user.model.bean.Reg_Bean;
>>>>>>> b4871d6ccc6b49c12bdc73575ada517b245024a6
>>>>>>> fc00618263e70f6355d836b3c5356c4ddb7388f2
import com.bwie.wangkui.quarter_hour.video.bean.ShowVideo_Bean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

<<<<<<< HEAD
=======

import com.bwie.wangkui.quarter_hour.video.bean.ShowVideo_Bean;
import com.bwie.wangkui.quarter_hour.video.bean.VicinityBean;

>>>>>>> fc00618263e70f6355d836b3c5356c4ddb7388f2
import java.util.HashMap;


import retrofit2.http.QueryMap;

import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ThinkPad on 2018/4/24.
 */

public interface ApiService {
<<<<<<< HEAD


        @GET("quarter/getHotVideos")
        Flowable<ShowVideo_Bean> show_video(@QueryMap HashMap<String,String> map);
    //广告接口
=======
    //附近视频
    @GET("quarter/getHotVideos")
    Flowable<VicinityBean> vicinity(@QueryMap HashMap<String,String> map);

        @GET("quarter/getHotVideos")
        Flowable<ShowVideo_Bean> show_video(@QueryMap HashMap<String,String> map);
        //登录
        @GET("user/login")
        Flowable<Login_Bean> getLogin(@Query("mobile") String mobile, @Query("password") String password);
<<<<<<< HEAD
        //视频详情
        @GET("quarter/getVideoDetail")
        Flowable<Details_Bean> details(@QueryMap HashMap<String,String> map );
=======
        //注册   https://www.zhaoapi.cn/quarter/register
        @GET("quarter/register")
        Flowable<Reg_Bean> getReg(@Query("mobile") String mobile, @Query("password") String password);
>>>>>>> b4871d6ccc6b49c12bdc73575ada517b245024a6

   /* //广告接口
// 9f42f2314ab1b5de01d6d7158a8b403eff5f2e55
>>>>>>> 31bd2277432b15d1e8c69e8f282ef95f4fca5818
>>>>>>> fc00618263e70f6355d836b3c5356c4ddb7388f2
    @GET("quarter/getAd")
    Observable<Bean> get();*/

    //获取视频作品列表
    @GET("quarter/getVideos")
    Flowable<ReMen_Bean> getRM(@Query("page") String page);

}
