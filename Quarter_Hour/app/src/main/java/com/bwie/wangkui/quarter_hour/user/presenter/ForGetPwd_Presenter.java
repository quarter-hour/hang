package com.bwie.wangkui.quarter_hour.user.presenter;

import com.bwie.wangkui.quarter_hour.base.BasePresenter;
import com.bwie.wangkui.quarter_hour.user.model.ForGetPwd_Model;
import com.bwie.wangkui.quarter_hour.user.model.bean.ForGetPwdBean;
import com.bwie.wangkui.quarter_hour.user.view.ForGetPwd_View;

/**
 * Created by Administrator on 2018/4/26.
 */

public class ForGetPwd_Presenter extends BasePresenter<ForGetPwd_View> {

    public ForGetPwd_Presenter(ForGetPwd_View iview) {
        super(iview);
    }
    public void getForGetPwdPresenter(String mobile,String newPass, final ForGetPwd_View forGetPwd_view){
        new ForGetPwd_Model().getForGetPwdModel(mobile, newPass, new ForGetPwd_Model.OnGetListener() {

            @Override
            public void ForGetPdwSuccess(ForGetPwdBean forGetPwdBean) {
                if (Iview!=null){
                    Iview.OnSuccese(forGetPwdBean);
                }
            }

            @Override
            public void ForGetPdwFail(String s) {
                if (Iview!=null){
                    Iview.onError(s);
                }
            }
        });
    }

}
