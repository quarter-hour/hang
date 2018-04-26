package com.bwie.wangkui.quarter_hour.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.wangkui.quarter_hour.MainActivity;
import com.bwie.wangkui.quarter_hour.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 点击注册账号 跳转到 注册页面
 */
public class RegActivity extends AppCompatActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.existing)
    TextView existing;
    @BindView(R.id.reg_name)
    EditText regName;
    @BindView(R.id.reg_pwd)
    EditText regPwd;
    @BindView(R.id.regbut)
    Button regbut;
    @BindView(R.id.Tourist)
    TextView Tourist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.existing, R.id.reg_name, R.id.reg_pwd, R.id.regbut, R.id.Tourist})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                RegActivity.this.overridePendingTransition(R.anim.close_in, R.anim.close_out);
                break;
            case R.id.existing:
                startActivity(new Intent(RegActivity.this, LoginActivity.class));
                RegActivity.this.overridePendingTransition(R.anim.start_in, R.anim.start_out);
                break;
            /*case R.id.reg_name:
                break;
            case R.id.reg_pwd:
                break;*/
            case R.id.regbut:

                break;
            case R.id.Tourist:
                startActivity(new Intent(RegActivity.this, MainActivity.class));
                RegActivity.this.overridePendingTransition(R.anim.start_in, R.anim.start_out);
                break;
        }
    }
}
