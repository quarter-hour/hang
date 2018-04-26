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
 * 点击其他登录 跳转到 登录页面
 */
public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.reg)
    TextView reg;
    @BindView(R.id.login_name)
    EditText login_name;
    @BindView(R.id.login_pwd)
    EditText login_pwd;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.forgetpwd)
    TextView forgetpwd;
    @BindView(R.id.Tourist)
    TextView Tourist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.back, R.id.reg, R.id.login_name, R.id.login_pwd, R.id.login, R.id.forgetpwd, R.id.Tourist})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                LoginActivity.this.overridePendingTransition(R.anim.close_in, R.anim.close_out);
                break;
            case R.id.reg:
                startActivity(new Intent(LoginActivity.this, RegActivity.class));
                LoginActivity.this.overridePendingTransition(R.anim.start_in, R.anim.start_out);
                break;
            case R.id.login_name:
                break;
            case R.id.login_pwd:
                break;
            case R.id.login:
                break;
            case R.id.forgetpwd:
                startActivity(new Intent(LoginActivity.this, ForgetpwdActivity.class));
                LoginActivity.this.overridePendingTransition(R.anim.start_in, R.anim.start_out);
                break;
            case R.id.Tourist:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                LoginActivity.this.overridePendingTransition(R.anim.start_in, R.anim.start_out);
                break;
        }
    }
}
