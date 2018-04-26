package com.bwie.wangkui.quarter_hour.video.presenter;

import com.bwie.wangkui.quarter_hour.base.BasePresenter;
import com.bwie.wangkui.quarter_hour.video.bean.Details_Bean;
import com.bwie.wangkui.quarter_hour.video.modle.Details_Modle;
import com.bwie.wangkui.quarter_hour.video.view.Details_View;

/**
 * Created by dell on 2018/4/26.
 */

public class Details_Presenter extends BasePresenter<Details_View>{

    public Details_Presenter(Details_View iview) {
        super(iview);
    }

    public void details_presenter(int wid){

        new Details_Modle().details_modle(wid, new Details_Modle.detailsListenner() {
            @Override
            public void detailsFail(String s) {
                if (Iview!=null){
                    Iview.Details_Fail(s);
                }
            }

            @Override
            public void detailsSuccess(Details_Bean details_bean) {

                if (Iview!=null){
                    Iview.Details_Sussessce(details_bean);
                }

            }
        });
    }
}
