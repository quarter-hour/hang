package com.bwie.wangkui.quarter_hour.base;

import android.content.Context;

import com.bwie.wangkui.quarter_hour.MainActivity;
import com.bwie.wangkui.quarter_hour.MyApplication;

/**
 * Created by dell on 2018/4/24.
 */

public class BasePresenter<V extends BaseView> {

    protected V Iview;

    public BasePresenter(V iview) {
        Iview = iview;
    }

    public void onDestroy(){

        Iview = null;
    }

    public Context context(){

        if (Iview!=null&&Iview.getContext()!=null){

            return Iview.getContext();
        }
        return MyApplication.getMyApplication();
    }

}
