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

public class ForgetpwdActivity extends AppCompatActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.existing)
    TextView existing;
    @BindView(R.id.forget_number)
    EditText forgetNumber;
    @BindView(R.id.forget_code)
    EditText forgetCode;
    @BindView(R.id.nextbut)
    Button nextbut;
    @BindView(R.id.Tourist)
    TextView Tourist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpwd);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.existing, R.id.forget_number, R.id.forget_code, R.id.nextbut, R.id.Tourist})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                ForgetpwdActivity.this.overridePendingTransition(R.anim.close_in, R.anim.close_out);
                break;
            case R.id.existing:
                startActivity(new Intent(ForgetpwdActivity.this, LoginActivity.class));
                ForgetpwdActivity.this.overridePendingTransition(R.anim.start_in, R.anim.start_out);
                break;
            case R.id.forget_number:
                break;
            case R.id.forget_code:
                break;
            case R.id.nextbut:
                startActivity(new Intent(ForgetpwdActivity.this, ConfirmActivity.class));
                break;
            case R.id.Tourist:
                startActivity(new Intent(ForgetpwdActivity.this, MainActivity.class));
                ForgetpwdActivity.this.overridePendingTransition(R.anim.start_in, R.anim.start_out);
                break;
        }
    }
}
