package com.bwie.wangkui.quarter_hour.user.presenter;

import com.bwie.wangkui.quarter_hour.base.BasePresenter;
import com.bwie.wangkui.quarter_hour.user.model.Login_Model;
import com.bwie.wangkui.quarter_hour.user.model.bean.Login_Bean;
import com.bwie.wangkui.quarter_hour.user.view.Login_View;

/**
 * Created by Administrator on 2018/4/26.
 */

public class Login_Presenter extends BasePresenter<Login_View> {

    public Login_Presenter(Login_View iview) {
        super(iview);
    }
    public void getLoginPresenter(String mobile, String password, final Login_View login_view){
        new Login_Model().getLoginModel(mobile, password, new Login_Model.OnGetListener() {
            @Override
            public void LoginSuccess(Login_Bean login_bean) {
                if (Iview!=null){
                    Iview.OnSuccese(login_bean);
                }
            }

            @Override
            public void LoginFail(String s) {
                if (Iview!=null){
                    Iview.onError(s);
                }
            }
        });
    }

}
