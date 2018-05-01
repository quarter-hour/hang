package com.bwie.wangkui.quarter_hour.user.model;

import com.bwie.wangkui.quarter_hour.user.model.bean.ForGetPwdBean;
import com.bwie.wangkui.quarter_hour.utils.API;
import com.bwie.wangkui.quarter_hour.utils.ApiService;
import com.bwie.wangkui.quarter_hour.utils.RetrofitUtlis;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * Created by Administrator on 2018/4/26.
 */

public class ForGetPwd_Model {

    public void getForGetPwdModel(String mobile,String newPass,final OnGetListener onGetListener ){
        ApiService apiService = RetrofitUtlis
                .getInstance(API.BASEURL)
                .getApiService(ApiService.class);

        Flowable<ForGetPwdBean> flowable = apiService.getForGetPwd(mobile, newPass);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<ForGetPwdBean>() {
                    @Override
                    public void onNext(ForGetPwdBean forGetPwdBean) {
                        if (onGetListener!=null){
                            onGetListener.ForGetPdwSuccess(forGetPwdBean);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        if (onGetListener!=null){
                            onGetListener.ForGetPdwFail(t.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
    public interface OnGetListener{
        void ForGetPdwSuccess(ForGetPwdBean forGetPwdBean);
        void ForGetPdwFail(String s);
    }
}
