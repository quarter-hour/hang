package com.bwie.wangkui.quarter_hour.video.view;

import com.bwie.wangkui.quarter_hour.base.BaseView;
import com.bwie.wangkui.quarter_hour.video.bean.ShowVideo_Bean;

/**
 * Created by dell on 2018/4/25.
 */

public interface ShowVideo_View extends BaseView{

    /*
    *展示视频图片的view 层
    * */
    void showVideoFail(String s);

    void showVideoSuccess(ShowVideo_Bean showVideo_bean);

}
