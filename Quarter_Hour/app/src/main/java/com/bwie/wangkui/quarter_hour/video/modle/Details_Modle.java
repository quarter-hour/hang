package com.bwie.wangkui.quarter_hour.video.modle;

import android.util.Log;

import com.bwie.wangkui.quarter_hour.utils.API;
import com.bwie.wangkui.quarter_hour.utils.ApiService;
import com.bwie.wangkui.quarter_hour.utils.RetrofitUtlis;
import com.bwie.wangkui.quarter_hour.video.bean.Details_Bean;

import java.util.HashMap;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * Created by dell on 2018/4/26.
 */

public class Details_Modle {

    public void details_modle(int wid, final detailsListenner listenner){

        ApiService apiService = RetrofitUtlis.getInstance(API.BASEURL).getApiService(ApiService.class);
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("wid",wid+"");
        Flowable<Details_Bean> details = apiService.details(hashMap);

        details.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DefaultSubscriber<Details_Bean>() {
                    @Override
                    public void onNext(Details_Bean details_bean) {

                        if (listenner!=null){
                            listenner.detailsSuccess(details_bean);
                        }

                    }

                    @Override
                    public void onError(Throwable t) {

                        if (listenner!=null){
                            listenner.detailsFail(t.getMessage());
                        }
                        Log.e("t",t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface detailsListenner{


        void detailsFail(String s);

        void detailsSuccess(Details_Bean details_bean);

    }



}
