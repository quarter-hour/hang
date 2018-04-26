package com.bwie.wangkui.quarter_hour.video.presenter;

import com.bwie.wangkui.quarter_hour.base.BasePresenter;
import com.bwie.wangkui.quarter_hour.video.bean.ShowVideo_Bean;
import com.bwie.wangkui.quarter_hour.video.modle.ShowVideo_Model;
import com.bwie.wangkui.quarter_hour.video.view.ShowVideo_View;

/**
 * Created by dell on 2018/4/25.
 */

public class ShowVideo_Presenter extends BasePresenter<ShowVideo_View>{
/*
*展示视频图片的Presenter 层
* */

    public ShowVideo_Presenter(ShowVideo_View iview) {
        super(iview);
    }

    public void showVideo_present( String page){

        new ShowVideo_Model().showVideo_Modle(page, new ShowVideo_Model.VideoListenner() {
            @Override
            public void videoFail(String s) {
                if (Iview!=null){
                    Iview.showVideoFail(s);
                }
            }

            @Override
            public void videoSuccess(ShowVideo_Bean showVideo_bean) {

                if (Iview!=null){
                    Iview.showVideoSuccess(showVideo_bean);
                }

            }
        });

    }

}
