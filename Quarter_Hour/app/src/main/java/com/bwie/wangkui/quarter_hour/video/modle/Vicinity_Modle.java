package com.bwie.wangkui.quarter_hour.video.modle;

import com.bwie.wangkui.quarter_hour.utils.API;
import com.bwie.wangkui.quarter_hour.utils.ApiService;
import com.bwie.wangkui.quarter_hour.utils.RetrofitUtlis;
import com.bwie.wangkui.quarter_hour.video.bean.ShowVideo_Bean;
import com.bwie.wangkui.quarter_hour.video.bean.VicinityBean;

import java.util.HashMap;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * Created by dell on 2018/4/26.
 */

public class Vicinity_Modle {

    public void vicinity_Modle(String page,String latitude,String longitude, final vicinitylistenner listenner){
        ApiService apiService = RetrofitUtlis.getInstance(API.BASEURL).getApiService(ApiService.class);
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("token","android");
        hashMap.put("page",page);

        Flowable<VicinityBean> vicinity = apiService.vicinity(hashMap);

        vicinity.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DefaultSubscriber<VicinityBean>() {
                    @Override
                    public void onNext(VicinityBean vicinityBean) {
                        if (listenner!=null){
                            listenner.vicinitySuccess(vicinityBean);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {

                        if (listenner!=null){
                            listenner.vicinityFail(t.getMessage());
                        }

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }


    public interface vicinitylistenner{

        void vicinityFail(String s);

        void vicinitySuccess(VicinityBean vicinityBean);
    }
}


