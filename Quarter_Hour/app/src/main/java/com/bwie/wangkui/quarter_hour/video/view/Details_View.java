package com.bwie.wangkui.quarter_hour.video.view;

import com.bwie.wangkui.quarter_hour.base.BaseView;
import com.bwie.wangkui.quarter_hour.video.bean.Details_Bean;

/**
 * Created by dell on 2018/4/26.
 */

public interface Details_View extends BaseView{

    void Details_Fail(String s);

    void Details_Sussessce(Details_Bean details_bean);
}
