package com.bwie.wangkui.quarter_hour.video.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bwie.wangkui.quarter_hour.MainActivity;
import com.bwie.wangkui.quarter_hour.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayerStandard;


public class Video_show_video extends AppCompatActivity {
    @BindView(R.id.videoplayer)
    JZVideoPlayerStandard mVideoplayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_show_video);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String videourl = intent.getStringExtra("videourl");
        String cover = intent.getStringExtra("cover");
        String workDesc = intent.getStringExtra("workDesc");
        Log.i("videourl", videourl);

        if (workDesc.equals("")){
            mVideoplayer.setUp(videourl
                    , JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "无标题");
//        JZVideoPlayerStandard.thumbImageView.setImage("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");
            Glide.with(Video_show_video.this).load(cover).into(mVideoplayer.thumbImageView);
        }else{
            mVideoplayer.setUp(videourl
                    , JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, workDesc);
//        JZVideoPlayerStandard.thumbImageView.setImage("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");
            Glide.with(Video_show_video.this).load(cover).into(mVideoplayer.thumbImageView);
        }

    }


}
