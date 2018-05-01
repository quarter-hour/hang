package com.bwie.wangkui.quarter_hour.jokes.presenter;

import android.util.Log;

import com.bwie.wangkui.quarter_hour.base.BasePresenter;
import com.bwie.wangkui.quarter_hour.jokes.model.Duanzi_Model;
import com.bwie.wangkui.quarter_hour.jokes.model.bean.DuanZi;
import com.bwie.wangkui.quarter_hour.jokes.view.Dz_View;
import com.bwie.wangkui.quarter_hour.recommend.recommend_model.ReMen_Bean;
import com.bwie.wangkui.quarter_hour.recommend.recommend_model.ReMen_Model;
import com.bwie.wangkui.quarter_hour.recommend.recommend_view.ReMen_View;

/**
 * Created by DELL on 2018/5/1.
 */

public class Dz_Presenter extends BasePresenter<Dz_View> {
    public Dz_Presenter(Dz_View iview) {
        super(iview);
    }


    public void relance(String page,String uid){
        new Duanzi_Model().getServer(page, uid, new Duanzi_Model.CallBackDate() {
            @Override
            public void faliure(String s) {
                if(Iview!=null){
                    Iview.filure(s);
                    Log.e("presenter","失败");
                }
            }

            @Override
            public void success(DuanZi duanZi) {
                if(Iview!=null){
                    Iview.success(duanZi);
                }
            }
        });
    }

}
