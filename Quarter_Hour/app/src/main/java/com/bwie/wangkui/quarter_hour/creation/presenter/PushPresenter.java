package com.bwie.wangkui.quarter_hour.creation.presenter;

import com.bwie.wangkui.quarter_hour.creation.model.PushModel;
import com.bwie.wangkui.quarter_hour.creation.view.PushIview;

import java.util.HashMap;
import java.util.List;

import okhttp3.MultipartBody;

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
    public void guanlian(HashMap<String,String> map,  List<MultipartBody.Part> listParts){
        pushModel.getData(map,listParts);
        pushModel.setCallBackPushData(new PushModel.CallBackPushData() {
            @Override
            public void callBackPushData(String s) {
                pushIview.onSuccess(s);
            }
        });
    }
}
