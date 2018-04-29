package com.bwie.wangkui.quarter_hour.utils;

import com.bwie.wangkui.quarter_hour.user.model.bean.ForGetPwdBean;
import com.bwie.wangkui.quarter_hour.user.model.bean.Login_Bean;
import com.bwie.wangkui.quarter_hour.user.model.bean.Reg_Bean;
import com.bwie.wangkui.quarter_hour.video.bean.ShowVideo_Bean;

import retrofit2.http.GET;
import com.bwie.wangkui.quarter_hour.creation.model.PushBean;
import com.bwie.wangkui.quarter_hour.recommend.recommend_model.ReMen_Bean;
import com.bwie.wangkui.quarter_hour.user.model.bean.Login_Bean;
import com.bwie.wangkui.quarter_hour.video.bean.Details_Bean;
import com.bwie.wangkui.quarter_hour.user.model.bean.Reg_Bean;

import okhttp3.MultipartBody;
import io.reactivex.Flowable;


import com.bwie.wangkui.quarter_hour.video.bean.VicinityBean;

import java.util.HashMap;
import java.util.List;

import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

import io.reactivex.Flowable;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryMap;

import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ThinkPad on 2018/4/24.
 */

public interface ApiService {

        //热门视频
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
    //广告接口
        //附近视频
        @GET("quarter/getHotVideos")
        Flowable<VicinityBean> vicinity(@QueryMap HashMap<String,String> map);

        //登录
        @GET("user/login")
        Flowable<Login_Bean> getLogin(@Query("mobile") String mobile, @Query("password") String password);
        //视频详情
        @GET("quarter/getVideoDetail")
        Flowable<Details_Bean> details(@QueryMap HashMap<String,String> map );
        //注册   https://www.zhaoapi.cn/quarter/register
        @GET("quarter/register")
        Flowable<Reg_Bean> getReg(@Query("mobile") String mobile, @Query("password") String password);
        //忘记密码  https://www.zhaoapi.cn/quarter/getPass?mobile=13017603237&newPass=123456
        @GET("quarter/getPass")
        Flowable<ForGetPwdBean> getForGetPwd(@Query("mobile") String mobile, @Query("newPass") String newPass);

   /* //广告接口

    @GET("quarter/getAd")
    Observable<Bean> get();*/

    //获取视频作品列表
    @GET("quarter/getVideos")
    Flowable<ReMen_Bean> getRM(@Query("page") String page);

}
