package com.bwie.wangkui.quarter_hour.video.presenter;

import com.bwie.wangkui.quarter_hour.base.BasePresenter;
import com.bwie.wangkui.quarter_hour.video.bean.ThumbsBean;
import com.bwie.wangkui.quarter_hour.video.modle.ThumbsModle;
import com.bwie.wangkui.quarter_hour.video.view.ThumbsView;

/**
 * Created by dell on 2018/4/27.
 */

public class ThumbsPresenter extends BasePresenter<ThumbsView>{

    public ThumbsPresenter(ThumbsView iview) {
        super(iview);
    }

    public void thumbs_presenter(String wid,String uid){

        new ThumbsModle().thumbsModle(wid, uid, new ThumbsModle.thumbsListenner() {
            @Override
            public void thubs_Fail(String s) {

                if (Iview!=null){
                    Iview.thumbsFail(s);
                }

            }

            @Override
            public void thubs_Success(ThumbsBean thumbsBean) {

                if (Iview!=null){
                    Iview.thumbsSuccess(thumbsBean);
                }


            }
        });

    }
}
