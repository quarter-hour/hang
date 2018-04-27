package com.bwie.wangkui.quarter_hour.user.view;

import com.bwie.wangkui.quarter_hour.base.BaseView;
import com.bwie.wangkui.quarter_hour.user.model.bean.FocusBean;

/**
 * Created by dell on 2018/4/27.
 */

public interface FocusView extends BaseView{


    void focus_Fail(String s);

    void focus_Success(FocusBean focusBean);

}
