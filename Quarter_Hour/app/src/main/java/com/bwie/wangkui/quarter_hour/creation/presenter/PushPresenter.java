package com.bwie.wangkui.quarter_hour.creation.presenter;

import com.bwie.wangkui.quarter_hour.creation.model.PushModel;
import com.bwie.wangkui.quarter_hour.creation.view.PushIview;

/**
 * Created by ThinkPad on 2018/4/26.
 */

public class PushPresenter {
       private PushModel pushModel;
       private PushIview pushIview;

    public PushPresenter(PushIview pushIview) {
        this.pushIview = pushIview;
        pushModel = new PushModel();
    }

    //关联
    public void guanlian(){
        pushModel.getData();
        pushModel.setCallBackPushData(new PushModel.CallBackPushData() {
            @Override
            public void callBackPushData(String s) {
                pushIview.onSuccess(s);
            }
        });
    }
}
