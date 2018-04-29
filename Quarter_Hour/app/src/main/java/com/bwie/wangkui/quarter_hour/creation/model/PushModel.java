package com.bwie.wangkui.quarter_hour.creation.model;



import com.bwie.wangkui.quarter_hour.utils.API;
import com.bwie.wangkui.quarter_hour.utils.ApiService;
import com.bwie.wangkui.quarter_hour.utils.L;
import com.bwie.wangkui.quarter_hour.utils.RetrofitUtlis;


import java.util.HashMap;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;
import okhttp3.MultipartBody;




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
        public void getData(HashMap<String,String> map, List<MultipartBody.Part> listParts){
           ApiService apiService = RetrofitUtlis.getInstance(API.BASEURL).getApiService(ApiService.class);
            Flowable<PushBean> flowable = apiService.push(map, listParts);
            flowable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DefaultSubscriber<PushBean>() {
                        @Override
                        public void onNext(PushBean pushBean) {
                            L.e("段子发表modelo网络请求成功");
                            L.e("--"+pushBean.getMsg());
                            callBackPushData.callBackPushData(pushBean.getMsg());
                        }

                        @Override
                        public void onError(Throwable t) {
                            L.e(t.getMessage()+"啥玩意啊");
                        }
                        @Override
                        public void onComplete() {

                        }
                    });



        }}
