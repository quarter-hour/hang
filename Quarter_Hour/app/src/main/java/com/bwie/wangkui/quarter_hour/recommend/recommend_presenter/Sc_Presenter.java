package com.bwie.wangkui.quarter_hour.recommend.recommend_presenter;

import android.util.Log;

import com.bwie.wangkui.quarter_hour.base.BasePresenter;
import com.bwie.wangkui.quarter_hour.recommend.recommend_model.ReMen_Bean;
import com.bwie.wangkui.quarter_hour.recommend.recommend_model.ReMen_Model;
import com.bwie.wangkui.quarter_hour.recommend.recommend_model.ShouCang;
import com.bwie.wangkui.quarter_hour.recommend.recommend_model.ShouCang_Model;
import com.bwie.wangkui.quarter_hour.recommend.recommend_view.ReMen_View;
import com.bwie.wangkui.quarter_hour.recommend.recommend_view.Sc_View;

/**
 * Created by DELL on 2018/5/1.
 */

public class Sc_Presenter extends BasePresenter<Sc_View>{


    public Sc_Presenter(Sc_View iview) {
        super(iview);
    }

    public void relance( String wid,String token){
        new ShouCang_Model().getServer(wid,token, new ShouCang_Model.CallBackDate() {
            @Override
            public void faliure(String s) {
                if(Iview!=null){
                    Iview.filure(s);
                    Log.e("presenter","失败");
                }
            }

            @Override
            public void success(ShouCang shouCang) {
                if(Iview!=null){
                    Iview.success(shouCang);
                }
            }
        });
    }

}
