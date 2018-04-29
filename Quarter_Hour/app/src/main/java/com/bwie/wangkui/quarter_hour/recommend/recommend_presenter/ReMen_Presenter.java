package com.bwie.wangkui.quarter_hour.recommend.recommend_presenter;

import android.util.Log;

import com.bwie.wangkui.quarter_hour.base.BasePresenter;
import com.bwie.wangkui.quarter_hour.recommend.recommend_model.ReMen_Bean;
import com.bwie.wangkui.quarter_hour.recommend.recommend_model.ReMen_Model;
import com.bwie.wangkui.quarter_hour.recommend.recommend_view.ReMen_View;

/**
 * Created by DELL on 2018/4/26.
 */

public class ReMen_Presenter extends BasePresenter<ReMen_View> {

    public ReMen_Presenter(ReMen_View iview) {
        super(iview);
    }

    public void relance(String page,String uid){
        new ReMen_Model().getServer(page,uid, new ReMen_Model.CallBackDate() {
            @Override
            public void faliure(String s) {
                if(Iview!=null){
                    Iview.filure(s);
                    Log.e("presenter","失败");
                }
            }

            @Override
            public void success(ReMen_Bean reMenBean) {
                if(Iview!=null){
                    Iview.success(reMenBean);
//                    Log.e("获取数据",reMenBean.getData().size()+"");
                }
            }
        });
    }
}
