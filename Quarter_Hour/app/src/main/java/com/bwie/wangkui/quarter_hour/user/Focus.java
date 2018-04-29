package com.bwie.wangkui.quarter_hour.user;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.bwie.wangkui.quarter_hour.MyApplication;
import com.bwie.wangkui.quarter_hour.R;
import com.bwie.wangkui.quarter_hour.base.BaseActivity;
import com.bwie.wangkui.quarter_hour.base.BasePresenter;
import com.bwie.wangkui.quarter_hour.user.adapter.FocusAdapter;
import com.bwie.wangkui.quarter_hour.user.model.bean.FocusBean;
import com.bwie.wangkui.quarter_hour.user.presenter.FocusPresenter;
import com.bwie.wangkui.quarter_hour.user.view.FocusView;
import com.bwie.wangkui.quarter_hour.utils.SharedPreferancesUtil;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Focus extends BaseActivity<FocusPresenter> implements FocusView{

    @BindView(R.id.focus_recycleview)
    XRecyclerView mFocusRecycleview;
    private int uid;


    @Override
    public int getLayout() {
        return R.layout.activity_focus;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        SharedPreferancesUtil user = SharedPreferancesUtil.getSPInstance(MyApplication.myApplication, "User");
        uid = (int) user.getSharedPreference("uid", 0);
        Log.i("uidd",uid+"");
        presenter.focus_presenter(uid+"");
        mFocusRecycleview.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public FocusPresenter getPresenter() {
        return new FocusPresenter(this);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void focus_Fail(String s) {
        Log.i("erros",s);
    }

    @Override
    public void focus_Success(FocusBean focusBean) {
        Log.i("focusBean",focusBean.getData().size()+"");
        List<FocusBean.DataBean> data = focusBean.getData();
        FocusAdapter focusAdapter = new FocusAdapter(data,this);
        mFocusRecycleview.setAdapter(focusAdapter);
    }
}
