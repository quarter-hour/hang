package com.bwie.wangkui.quarter_hour.video.view;

import com.bwie.wangkui.quarter_hour.base.BaseView;
import com.bwie.wangkui.quarter_hour.video.bean.User_Video_Bean;

/**
 * Created by dell on 2018/4/27.
 */

public interface User_video_View extends BaseView{

    void user_video_Fial(String s);

    void user_video_Success(User_Video_Bean user_video_bean);
}
