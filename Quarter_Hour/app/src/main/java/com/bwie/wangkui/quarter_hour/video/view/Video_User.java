package com.bwie.wangkui.quarter_hour.video.view;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.bwie.wangkui.quarter_hour.R;
import com.bwie.wangkui.quarter_hour.base.BaseActivity;
import com.bwie.wangkui.quarter_hour.video.adapter.User_Video_Adapter;
import com.bwie.wangkui.quarter_hour.video.bean.User_Video_Bean;
import com.bwie.wangkui.quarter_hour.video.presenter.User_Video_Presenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class Video_User extends BaseActivity<User_Video_Presenter> implements User_video_View{

    private XRecyclerView user_recyclerview;

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void user_video_Fial(String s) {

        Log.e("erro",s);

    }

    @Override
    public void user_video_Success(User_Video_Bean user_video_bean) {

        Log.i("user_video_bean",user_video_bean.getCode()+user_video_bean.getMsg());
        List<User_Video_Bean.DataBean.WorksEntitiesBean> worksEntities = user_video_bean.getData().getWorksEntities();
        User_Video_Adapter user_video_adapter = new User_Video_Adapter(worksEntities,this);
        user_recyclerview.setAdapter(user_video_adapter);

    }

    @Override
    public int getLayout() {
        return R.layout.video__user;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        int uid = intent.getIntExtra("uid", 0);
        presenter.userpresenter(uid+"");
        user_recyclerview = findViewById(R.id.user_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        user_recyclerview.setLayoutManager(linearLayoutManager);

    }

    @Override
    public User_Video_Presenter getPresenter() {
        return new User_Video_Presenter(this);
    }
}
