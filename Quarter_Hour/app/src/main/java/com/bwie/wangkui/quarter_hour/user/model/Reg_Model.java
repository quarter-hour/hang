package com.bwie.wangkui.quarter_hour.user.model;

import com.bwie.wangkui.quarter_hour.user.model.bean.Reg_Bean;
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

public class Reg_Model {
    public void getRegModel(String mobile,String password,final Reg_Model.OnGetListener onGetListener ){
        ApiService apiService = RetrofitUtlis
                .getInstance(API.BASEURL)
                .getApiService(ApiService.class);
        Flowable<Reg_Bean> flowable = apiService.getReg(mobile, password);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<Reg_Bean>() {
                    @Override
                    public void onNext(Reg_Bean reg_bean) {
                        if (onGetListener!=null){
                            onGetListener.RegSuccess(reg_bean);
                        }

                    }

                    @Override
                    public void onError(Throwable t) {
                        if (onGetListener!=null){
                            onGetListener.RegFail(t.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    public interface OnGetListener{
        void RegSuccess(Reg_Bean reg_bean);
        void RegFail(String s);
    }

}
