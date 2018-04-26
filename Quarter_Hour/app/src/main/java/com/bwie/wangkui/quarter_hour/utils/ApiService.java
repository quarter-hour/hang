package com.bwie.wangkui.quarter_hour.utils;

<<<<<<< HEAD
import com.bwie.wangkui.quarter_hour.creation.model.PushBean;
=======
<<<<<<< HEAD
import com.bwie.wangkui.quarter_hour.recommend.recommend_model.ReMen_Bean;
=======
>>>>>>> b3d52b13dd709331c2bb37bd23a2ecb41f9b0966
import com.bwie.wangkui.quarter_hour.user.model.bean.Login_Bean;
<<<<<<< HEAD
import com.bwie.wangkui.quarter_hour.video.bean.Details_Bean;
=======
import com.bwie.wangkui.quarter_hour.user.model.bean.Reg_Bean;
>>>>>>> b4871d6ccc6b49c12bdc73575ada517b245024a6
>>>>>>> fc00618263e70f6355d836b3c5356c4ddb7388f2
import com.bwie.wangkui.quarter_hour.video.bean.ShowVideo_Bean;

<<<<<<< HEAD
import okhttp3.MultipartBody;
import retrofit2.http.FormUrlEncoded;
=======
import io.reactivex.Flowable;
>>>>>>> b3d52b13dd709331c2bb37bd23a2ecb41f9b0966
import retrofit2.http.GET;

<<<<<<< HEAD
=======

import com.bwie.wangkui.quarter_hour.video.bean.ShowVideo_Bean;
import com.bwie.wangkui.quarter_hour.video.bean.VicinityBean;

>>>>>>> fc00618263e70f6355d836b3c5356c4ddb7388f2
import java.util.HashMap;
import java.util.List;

<<<<<<< HEAD
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
=======

>>>>>>> b3d52b13dd709331c2bb37bd23a2ecb41f9b0966
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
        @GET("quarter/getAd")
        Observable<Bean> get();
        //发表段子

        @Multipart
        @POST("quarter/publishJoke")
        Flowable<PushBean> push(@QueryMap HashMap<String,String> map, @Part List<MultipartBody.Part> listParts);



    //热门视频

=======
<<<<<<< HEAD


        @GET("quarter/getHotVideos")
        Flowable<ShowVideo_Bean> show_video(@QueryMap HashMap<String,String> map);
    //广告接口
=======
>>>>>>> b3d52b13dd709331c2bb37bd23a2ecb41f9b0966
    //附近视频
    @GET("quarter/getHotVideos")
    Flowable<VicinityBean> vicinity(@QueryMap HashMap<String,String> map);

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
<<<<<<< HEAD

=======
// 9f42f2314ab1b5de01d6d7158a8b403eff5f2e55
>>>>>>> 31bd2277432b15d1e8c69e8f282ef95f4fca5818
>>>>>>> fc00618263e70f6355d836b3c5356c4ddb7388f2
>>>>>>> b3d52b13dd709331c2bb37bd23a2ecb41f9b0966
    @GET("quarter/getAd")
    Observable<Bean> get();*/

    //获取视频作品列表
    @GET("quarter/getVideos")
    Flowable<ReMen_Bean> getRM(@Query("page") String page);

}
