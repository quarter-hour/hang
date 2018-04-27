package com.bwie.wangkui.quarter_hour.video.modle;

import com.bwie.wangkui.quarter_hour.utils.API;
import com.bwie.wangkui.quarter_hour.utils.ApiService;
import com.bwie.wangkui.quarter_hour.utils.RetrofitUtlis;
import com.bwie.wangkui.quarter_hour.video.bean.ThumbsBean;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.bwie.wangkui.quarter_hour.utils.RetrofitUtlis.getInstance;

/**
 * Created by dell on 2018/4/27.
 */

public class ThumbsModle {
    //wid uid
    public void thumbsModle(String wid, String uid, final thumbsListenner listenner){

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("wid",wid);
        hashMap.put("uid",uid);
        RetrofitUtlis
                .getInstance(API.BASEURL)
                .getApiService(ApiService.class)
                .thumbs(hashMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ThumbsBean>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(ThumbsBean thumbsBean) {

                        if (listenner!=null){
                            listenner.thubs_Success(thumbsBean);
                        }


                    }

                    @Override
                    public void onError(Throwable t) {

                        if (listenner!=null){

                            listenner.thubs_Fail(t.getMessage());
                        }

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface thumbsListenner{

        void thubs_Fail(String s);

        void thubs_Success(ThumbsBean thumbsBean);

    }
}
