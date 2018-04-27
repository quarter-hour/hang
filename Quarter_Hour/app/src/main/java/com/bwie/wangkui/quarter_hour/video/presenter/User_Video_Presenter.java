package com.bwie.wangkui.quarter_hour.video.presenter;

import com.bwie.wangkui.quarter_hour.base.BasePresenter;
import com.bwie.wangkui.quarter_hour.video.bean.User_Video_Bean;
import com.bwie.wangkui.quarter_hour.video.modle.User_Viedo_Model;
import com.bwie.wangkui.quarter_hour.video.view.User_video_View;

/**
 * Created by dell on 2018/4/27.
 */

public class User_Video_Presenter extends BasePresenter<User_video_View>{
    public User_Video_Presenter(User_video_View iview) {
        super(iview);
    }

    public void userpresenter(String uid){
        new User_Viedo_Model().String(uid, new User_Viedo_Model.userlistenner() {
            @Override
            public void userFail(String s) {
                if (Iview!=null){
                    Iview.user_video_Fial(s);
                }
            }

            @Override
            public void userSuccess(User_Video_Bean user_video_bean) {

                if (Iview!=null){
                    Iview.user_video_Success(user_video_bean);
                }

            }
        });
    }
}
