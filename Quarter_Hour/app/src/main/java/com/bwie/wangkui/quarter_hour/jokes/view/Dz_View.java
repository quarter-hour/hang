package com.bwie.wangkui.quarter_hour.jokes.view;

import com.bwie.wangkui.quarter_hour.base.BaseView;
import com.bwie.wangkui.quarter_hour.jokes.model.bean.DuanZi;
import com.bwie.wangkui.quarter_hour.recommend.recommend_model.ShouCang;

/**
 * Created by DELL on 2018/5/1.
 */

public interface Dz_View extends BaseView {

    void filure(String s);

    void success(DuanZi duanZi);

}
