package com.bwie.wangkui.quarter_hour.recommend.recommend_model;

import android.util.Log;

import com.bwie.wangkui.quarter_hour.utils.API;
import com.bwie.wangkui.quarter_hour.utils.ApiService;
import com.bwie.wangkui.quarter_hour.utils.RetrofitUtlis;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;


/**
 * Created by DELL on 2018/4/26.
 */

public class ReMen_Model {


    public void getServer( String page,String uid, final CallBackDate callBackDate){
        ApiService apiService = RetrofitUtlis.getInstance(API.BASEURL).getApiService(ApiService.class);
        Flowable<ReMen_Bean> rm = apiService.getRM( page,uid);
        rm.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<ReMen_Bean>() {
                    @Override
                    public void onNext(ReMen_Bean reMenBean) {
                        callBackDate.success(reMenBean);
//                        Log.e("成功",reMenBean.getData().size()+"");
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e("错误--------",t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public interface CallBackDate{
        void faliure(String s);
        void success(ReMen_Bean reMenBean);
    }

}
