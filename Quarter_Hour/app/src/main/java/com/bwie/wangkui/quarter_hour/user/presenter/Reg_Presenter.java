package com.bwie.wangkui.quarter_hour.user.presenter;

import com.bwie.wangkui.quarter_hour.base.BasePresenter;
import com.bwie.wangkui.quarter_hour.user.model.Reg_Model;
import com.bwie.wangkui.quarter_hour.user.model.bean.Reg_Bean;
import com.bwie.wangkui.quarter_hour.user.view.Reg_View;

/**
 * Created by Administrator on 2018/4/26.
 */

public class Reg_Presenter extends BasePresenter<Reg_View> {

    public Reg_Presenter(Reg_View iview) {
        super(iview);
    }
    public void getRetPresenter(String mobile, String password, final Reg_View reg_view){
        new Reg_Model().getRegModel(mobile, password, new Reg_Model.OnGetListener() {
            @Override
            public void RegSuccess(Reg_Bean reg_bean) {
                if (Iview!=null){
                    Iview.OnSuccese(reg_bean);
                }
            }

            @Override
            public void RegFail(String s) {
                if (Iview!=null){
                    Iview.onError(s);
                }
            }
        });
    }
}
