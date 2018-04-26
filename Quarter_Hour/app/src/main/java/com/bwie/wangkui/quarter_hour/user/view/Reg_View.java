package com.bwie.wangkui.quarter_hour.user.view;

import com.bwie.wangkui.quarter_hour.base.BaseView;
import com.bwie.wangkui.quarter_hour.user.model.bean.Reg_Bean;

/**
 * Created by Administrator on 2018/4/26.
 */

public interface Reg_View extends BaseView {
    void OnSuccese(Reg_Bean reg_bean);
    void onError(String s);
}
