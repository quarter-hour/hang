package com.bwie.wangkui.quarter_hour.creation.model;

import android.util.Log;

import com.bwie.wangkui.quarter_hour.utils.API;
import com.bwie.wangkui.quarter_hour.utils.ApiService;
import com.bwie.wangkui.quarter_hour.utils.L;
import com.bwie.wangkui.quarter_hour.utils.RetrofitUtlis;

import java.util.HashMap;

import io.reactivex.Flowable;
import io.reactivex.subscribers.DefaultSubscriber;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by ThinkPad on 2018/4/26.
 */

public class PushModel {

      public interface CallBackPushData{
          void callBackPushData(String s);
      }
      CallBackPushData callBackPushData;

    public void setCallBackPushData(CallBackPushData callBackPushData) {
        this.callBackPushData = callBackPushData;
    }

    //获取网络请求
        public void getData(){
            ApiService apiService = RetrofitUtlis.getInstance(API.BASEURL).getApiService(ApiService.class);
            HashMap<String, String> map = new HashMap<>();
            Flowable<String> flowable = apiService.push(map);
            flowable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DefaultSubscriber<String>() {
                        @Override
                        public void onNext(String s) {
                            L.e("段子发表modelo网络请求成功");
                        }

                        @Override
                        public void onError(Throwable t) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }

}
