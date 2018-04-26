package com.bwie.wangkui.quarter_hour.user.view;

import com.bwie.wangkui.quarter_hour.base.BaseView;
import com.bwie.wangkui.quarter_hour.user.model.bean.Login_Bean;

/**
 * Created by Administrator on 2018/4/26.
 */

public interface Login_View extends BaseView {

    void OnSuccese(Login_Bean login_bean);
    void onError(String s);
}
