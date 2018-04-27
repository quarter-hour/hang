package com.bwie.wangkui.quarter_hour.user.presenter;

import com.bwie.wangkui.quarter_hour.base.BasePresenter;
import com.bwie.wangkui.quarter_hour.user.model.FocusModel;
import com.bwie.wangkui.quarter_hour.user.model.bean.FocusBean;
import com.bwie.wangkui.quarter_hour.user.view.FocusView;

/**
 * Created by dell on 2018/4/27.
 */

public class FocusPresenter extends BasePresenter<FocusView>{

    public FocusPresenter(FocusView iview) {
        super(iview);
    }

    public void focus_presenter(String uid){


        new FocusModel().focus_model(uid, new FocusModel.focuslistenner() {
            @Override
            public void focesFail(String s) {
                if (Iview!=null){
                    Iview.focus_Fail(s);
                }
            }

            @Override
            public void focusSuccess(FocusBean focusBean) {
                if (Iview!=null){
                    Iview.focus_Success(focusBean);
                }
            }
        });

    }
}
