package com.bwie.wangkui.quarter_hour.video.view;

import com.bwie.wangkui.quarter_hour.base.BaseView;
import com.bwie.wangkui.quarter_hour.video.bean.ThumbsBean;

/**
 * Created by dell on 2018/4/27.
 */

public interface ThumbsView extends BaseView{

    void thumbsFail(String s);

    void thumbsSuccess(ThumbsBean thumbsBean);
}
