package com.bwie.wangkui.quarter_hour.video.view;

import com.bwie.wangkui.quarter_hour.base.BaseView;
import com.bwie.wangkui.quarter_hour.video.bean.VicinityBean;

/**
 * Created by dell on 2018/4/26.
 */

public interface Vicinty_View extends BaseView{

    void vicinty_videoFail(String s);

    void vicinty_videoSuccess(VicinityBean vicinityBean);
}
