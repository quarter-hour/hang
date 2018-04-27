package com.bwie.wangkui.quarter_hour.creation.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.wangkui.quarter_hour.R;
import com.bwie.wangkui.quarter_hour.creation.view.Article;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Creation extends AppCompatActivity {

    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.video)
    ImageView video;
    @BindView(R.id.text)
    ImageView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.video, R.id.text})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back://点击取消按钮 销毁页面
                finish();
                break;
            case R.id.video://点击视频图标 开始视频录制
                startActivity(new Intent(this,Streaming.class));
                break;
            case R.id.text://点击文本  开始创作
              startActivity(new Intent(this,Article.class));
                break;
        }
    }
}
