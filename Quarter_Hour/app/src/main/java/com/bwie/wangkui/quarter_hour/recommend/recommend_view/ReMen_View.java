package com.bwie.wangkui.quarter_hour.recommend.recommend_view;

import com.bwie.wangkui.quarter_hour.base.BaseView;
import com.bwie.wangkui.quarter_hour.recommend.recommend_model.ReMen_Bean;

/**
 * Created by DELL on 2018/4/26.
 */

public interface ReMen_View extends BaseView {

    void filure(String s);

    void success(ReMen_Bean reMenBean);

}
