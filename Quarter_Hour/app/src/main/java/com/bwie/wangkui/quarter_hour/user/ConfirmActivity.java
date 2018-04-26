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

public class ConfirmActivity extends AppCompatActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.existing)
    TextView existing;
    @BindView(R.id.confirm_pwd)
    EditText confirmPwd;
    @BindView(R.id.confirm_pwds)
    EditText confirmPwds;
    @BindView(R.id.finishbut)
    Button finishbut;
    @BindView(R.id.Tourist)
    TextView Tourist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.existing, R.id.confirm_pwd, R.id.confirm_pwds, R.id.finishbut, R.id.Tourist})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                ConfirmActivity.this.overridePendingTransition(R.anim.close_in, R.anim.close_out);
                break;
            case R.id.existing:
                startActivity(new Intent(ConfirmActivity.this, LoginActivity.class));
                ConfirmActivity.this.overridePendingTransition(R.anim.start_in, R.anim.start_out);
                break;
            /*case R.id.confirm_pwd:
                break;
            case R.id.confirm_pwds:
                break;*/
            case R.id.finishbut:
                startActivity(new Intent(ConfirmActivity.this, LoginActivity.class));
                break;
            case R.id.Tourist:
                startActivity(new Intent(ConfirmActivity.this, MainActivity.class));
                ConfirmActivity.this.overridePendingTransition(R.anim.start_in, R.anim.start_out);
                break;
        }
    }
}
