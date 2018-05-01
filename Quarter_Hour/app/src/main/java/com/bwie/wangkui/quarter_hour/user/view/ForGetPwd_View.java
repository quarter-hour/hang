package com.bwie.wangkui.quarter_hour.user.view;

import com.bwie.wangkui.quarter_hour.base.BaseView;
import com.bwie.wangkui.quarter_hour.user.model.bean.ForGetPwdBean;

/**
 * Created by Administrator on 2018/4/26.
 */

public interface ForGetPwd_View extends BaseView {
    void OnSuccese(ForGetPwdBean forGetPwdBean);
    void onError(String s);
}
