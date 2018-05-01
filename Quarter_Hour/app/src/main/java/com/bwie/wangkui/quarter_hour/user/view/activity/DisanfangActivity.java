package com.bwie.wangkui.quarter_hour.user.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.wangkui.quarter_hour.MainActivity;
import com.bwie.wangkui.quarter_hour.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 * 点击头像跳转到第三方登录页面
 */

public class DisanfangActivity extends AppCompatActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.weixin)
    ImageView weixin;
    @BindView(R.id.qq)
    ImageView qq;
    @BindView(R.id.rests)
    TextView rests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disanfang);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.weixin, R.id.qq, R.id.rests})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                DisanfangActivity.this.overridePendingTransition(R.anim.close_in, R.anim.close_out);
                break;
            case R.id.weixin:

                DisanfangActivity.this.overridePendingTransition(R.anim.start_in, R.anim.start_out);
                break;
            case R.id.qq:
                DisanfangActivity.this.overridePendingTransition(R.anim.start_in, R.anim.start_out);
                break;
            case R.id.rests:
                startActivity(new Intent(DisanfangActivity.this, LoginActivity.class));
               DisanfangActivity.this.overridePendingTransition(R.anim.start_in, R.anim.start_out);
                break;
        }
    }
}
