package com.bwie.wangkui.quarter_hour.video.presenter;

import com.bwie.wangkui.quarter_hour.base.BasePresenter;
import com.bwie.wangkui.quarter_hour.video.bean.VicinityBean;
import com.bwie.wangkui.quarter_hour.video.modle.Vicinity_Modle;
import com.bwie.wangkui.quarter_hour.video.view.Vicinty_View;

/**
 * Created by dell on 2018/4/26.
 */

public class Vicinty_Presenter extends BasePresenter<Vicinty_View>{

    public Vicinty_Presenter(Vicinty_View iview) {
        super(iview);
    }

    public void vicintyPresenter(String page,String latitude,String longitude){

        new Vicinity_Modle().vicinity_Modle(page, latitude, longitude, new Vicinity_Modle.vicinitylistenner() {
            @Override
            public void vicinityFail(String s) {
                if (Iview!=null){
                    Iview.vicinty_videoFail(s);
                }
            }

            @Override
            public void vicinitySuccess(VicinityBean vicinityBean) {

                if (Iview!=null){
                    Iview.vicinty_videoSuccess(vicinityBean);
                }
            }
        });
    }
}
