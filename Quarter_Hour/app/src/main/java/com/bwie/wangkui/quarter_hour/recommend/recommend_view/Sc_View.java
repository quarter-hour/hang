package com.bwie.wangkui.quarter_hour.recommend.recommend_view;

import com.bwie.wangkui.quarter_hour.base.BaseView;
import com.bwie.wangkui.quarter_hour.recommend.recommend_model.ReMen_Bean;
import com.bwie.wangkui.quarter_hour.recommend.recommend_model.ShouCang;

/**
 * Created by DELL on 2018/5/1.
 */

public interface Sc_View extends BaseView {

    void filure(String s);

    void success(ShouCang shouCang);

}
