package com.bwie.wangkui.quarter_hour.video.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bwie.wangkui.quarter_hour.MyApplication;
import com.bwie.wangkui.quarter_hour.R;
import com.bwie.wangkui.quarter_hour.base.BaseActivity;
import com.bwie.wangkui.quarter_hour.utils.SharedPreferancesUtil;
import com.bwie.wangkui.quarter_hour.video.bean.Details_Bean;
import com.bwie.wangkui.quarter_hour.video.bean.ThumbsBean;
import com.bwie.wangkui.quarter_hour.video.presenter.Details_Presenter;
import com.bwie.wangkui.quarter_hour.video.presenter.ThumbsPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;


public class Video_show_video extends BaseActivity<Details_Presenter> implements Details_View {
    @BindView(R.id.videoplayer)
    JZVideoPlayerStandard mVideoplayer;
    @BindView(R.id.xihuang_image)
    ImageView mXihuangImage;
    boolean falg = true;
    @BindView(R.id.fenxiang_image)
    ImageView mFenxiangImage;
    @BindView(R.id.fanhui_image)
    ImageView mFanhuiImage;
    private int wid;
    private String icon;
    private Intent intent;
    private int uid;


    @Override
    public int getLayout() {
        return R.layout.activity_video_show_video;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
//        wid = getIntent().getIntExtra("wid", 0);
        intent = getIntent();
        wid = intent.getIntExtra("wid",0);
        icon = intent.getStringExtra("icon");
        SharedPreferancesUtil user = SharedPreferancesUtil.getSPInstance(MyApplication.myApplication, "User");
        uid = (int) user.getSharedPreference("uid", 0);
        Log.i("wid",wid+"");
        Log.i("uid", uid +"");
        presenter.details_presenter(wid);
        //红心
        mXihuangImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (falg == true) {
                    mXihuangImage.setImageResource(R.mipmap.raw_1499933215);


                    ThumbsPresenter thumbsPresenter = new ThumbsPresenter(new ThumbsView() {
                        @Override
                        public void thumbsFail(String s) {

                            Log.e("erro",s);
                        }

                        @Override
                        public void thumbsSuccess(ThumbsBean thumbsBean) {

                            Toast.makeText(Video_show_video.this, ""+thumbsBean.getMsg(), Toast.LENGTH_SHORT).show();
                            Log.i("msg",thumbsBean.getMsg());
                        }

                        @Override
                        public Context getContext() {
                            return Video_show_video.this;
                        }
                    });

                    thumbsPresenter.thumbs_presenter(wid+"", uid +"");
                    falg = false;
                } else {
                    mXihuangImage.setImageResource(R.mipmap.raw_1499933216);
                    falg = true;

                }
            }
        });
        mFanhuiImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Glide.with(Video_show_video.this).load(icon).placeholder(R.mipmap.raw_1499917357).into(mFenxiangImage);

    }

    @Override
    public Details_Presenter getPresenter() {
        return new Details_Presenter(this);
    }

    @Override
    public Context getContext() {
        return Video_show_video.this;
    }

    @Override
    public void Details_Fail(String s) {

        Log.e("erro",s);
    }

    @Override
    public void Details_Sussessce(Details_Bean details_bean) {
        String msg = details_bean.getMsg();
        String videoUrl = details_bean.getData().getVideoUrl();
        String cover = details_bean.getData().getCover();
//        Log.i("qas",videoUrl);
        Details_Bean.DataBean data = details_bean.getData();
        Object workDesc = details_bean.getData().getWorkDesc();
        final int uid = details_bean.getData().getUid();
        Log.i("aaaq",data.getVideoUrl()+msg);
//        if (workDesc.equals("")){
        mVideoplayer.setUp(videoUrl
                , JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "无标题");
        Glide.with(Video_show_video.this).load(cover).into(mVideoplayer.thumbImageView);
        mFenxiangImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               intent = new Intent(Video_show_video.this,Video_User.class);
                intent.putExtra("uid",uid);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }
}
