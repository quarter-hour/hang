package com.bwie.wangkui.quarter_hour.user.model;

import com.bwie.wangkui.quarter_hour.user.model.bean.Login_Bean;
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

public class Login_Model {

    public void getLoginModel(String mobile,String password,final OnGetListener onGetListener ){
        ApiService apiService = RetrofitUtlis
                .getInstance(API.BASEURL)
                .getApiService(ApiService.class);

        Flowable flowable = apiService.getLogin(mobile, password);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<Login_Bean>() {
                    @Override
                    public void onNext(Login_Bean login_bean) {

                        if (onGetListener!=null){
                            onGetListener.LoginSuccess(login_bean);
                        }

                    }

                    @Override
                    public void onError(Throwable t) {
                        if (onGetListener!=null){
                            onGetListener.LoginFail(t.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
    public interface OnGetListener{
        void LoginFail(String s);
        void LoginSuccess(Login_Bean login_bean);
    }
}
