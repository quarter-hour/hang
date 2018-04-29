package com.bwie.wangkui.quarter_hour.video.modle;

import com.bwie.wangkui.quarter_hour.utils.API;
import com.bwie.wangkui.quarter_hour.utils.ApiService;
import com.bwie.wangkui.quarter_hour.utils.RetrofitUtlis;
import com.bwie.wangkui.quarter_hour.video.bean.User_Video_Bean;

import java.util.HashMap;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * Created by dell on 2018/4/27.
 */

public class User_Viedo_Model {

    public void String(String uid, final userlistenner userlistenner){


        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("uid",uid);

        Flowable<User_Video_Bean> user_video_beanFlowable = RetrofitUtlis
                .getInstance(API.BASEURL)
                .getApiService(ApiService.class)
                .user_video(hashMap);

        user_video_beanFlowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DefaultSubscriber<User_Video_Bean>() {
                    @Override
                    public void onNext(User_Video_Bean user_video_bean) {

                        if(userlistenner!=null){
                            userlistenner.userSuccess(user_video_bean);
                        }

                    }

                    @Override
                    public void onError(Throwable t) {

                        if (userlistenner!=null){
                            userlistenner.userFail(t.getMessage());
                        }

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
        public interface userlistenner{

            void userFail(String s);

            void userSuccess(User_Video_Bean user_video_bean);

        }
}
