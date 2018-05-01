package com.bwie.wangkui.quarter_hour.creation.presenter;

import com.bwie.wangkui.quarter_hour.creation.model.PushModel;
import com.bwie.wangkui.quarter_hour.creation.model.PushVideoModel;
import com.bwie.wangkui.quarter_hour.creation.view.PushIview;
import com.bwie.wangkui.quarter_hour.creation.view.PushVideoView;

import java.util.HashMap;
import java.util.List;

import okhttp3.MultipartBody;

/**
 * Created by ThinkPad on 2018/4/26.
 */

public class PushVideoPresenter {
       private PushVideoModel pushModel;
       private PushVideoView pushIview;

    public PushVideoPresenter(PushVideoView pushIview) {
        this.pushIview = pushIview;
        pushModel = new PushVideoModel();
    }

    //关联
    public void guanlian(HashMap<String,String> map,List<MultipartBody.Part> listParts){
        pushModel.getData(map,listParts);
        pushModel.setCallBackPushData(new PushVideoModel.CallBackPushData() {
            @Override
            public void callBackPushData(String s) {
                pushIview.Onsuccess(s);
            }
        });

    }
}
