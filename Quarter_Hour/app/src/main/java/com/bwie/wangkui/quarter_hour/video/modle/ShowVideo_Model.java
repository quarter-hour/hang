package com.bwie.wangkui.quarter_hour.video.modle;

import com.bwie.wangkui.quarter_hour.utils.API;
import com.bwie.wangkui.quarter_hour.utils.ApiService;
import com.bwie.wangkui.quarter_hour.utils.RetrofitUtlis;
import com.bwie.wangkui.quarter_hour.video.bean.ShowVideo_Bean;

import java.util.HashMap;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * Created by dell on 2018/4/25.
 */

public class ShowVideo_Model {

/*
*展示视频图片的modle 层
* */
    public void showVideo_Modle(String page, final VideoListenner listenner){
        ApiService apiService = RetrofitUtlis.getInstance(API.BASEURL).getApiService(ApiService.class);
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("token","android");
        hashMap.put("page",page);
        Flowable<ShowVideo_Bean> showVideo_beanFlowable = apiService.show_video(hashMap);
        showVideo_beanFlowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<ShowVideo_Bean>() {
                    @Override
                    public void onNext(ShowVideo_Bean showVideo_bean) {

                        if (listenner!=null){
                            listenner.videoSuccess(showVideo_bean);
                        }

                    }

                    @Override
                    public void onError(Throwable t) {
                                if (listenner!=null){
                                    listenner.videoFail(t.getMessage());
                                }
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    public interface VideoListenner{

        void videoFail(String s);

        void videoSuccess(ShowVideo_Bean showVideo_bean);
    }
}
