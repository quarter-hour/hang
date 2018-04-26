package com.bwie.wangkui.quarter_hour.video.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bwie.wangkui.quarter_hour.R;

import butterknife.ButterKnife;


public class Video_show_video extends AppCompatActivity {


//    private IjkVideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_show_video);
        initView();
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String videourl = intent.getStringExtra("videourl");
        Log.i("videourl", videourl);
//        IjkMediaPlayer.loadLibrariesOnce(null);
//        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
//        mVideoView.setVideoURI(Uri.parse("http://vod.cntv.lxdns.com/flash/mp4video61/TMS/2017/08/17/63bf8bcc706a46b58ee5c821edaee661_h264818000nero_aac32-5.mp4"));
//        mVideoView.start();

    }

    private void initView() {
//        mVideoView = (IjkVideoView) findViewById(R.id.video_view);
    }
}
