package com.bwie.wangkui.quarter_hour.user.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.wangkui.quarter_hour.MainActivity;
import com.bwie.wangkui.quarter_hour.R;
import com.bwie.wangkui.quarter_hour.user.model.bean.ForGetPwdBean;
import com.bwie.wangkui.quarter_hour.user.presenter.ForGetPwd_Presenter;
import com.bwie.wangkui.quarter_hour.user.view.ForGetPwd_View;

import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgetpwdActivity extends AppCompatActivity implements ForGetPwd_View {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.existing)
    TextView existing;
    @BindView(R.id.forget_number)
    EditText forgetNumber;
    @BindView(R.id.forget_newpass)
    EditText forgetNewpass;
    @BindView(R.id.nextbut)
    Button nextbut;
    @BindView(R.id.Tourist)
    TextView Tourist;
    private ForGetPwd_Presenter forGetPwd_presenter;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpwd);
        ButterKnife.bind(this);
        forGetPwd_presenter = new ForGetPwd_Presenter(this);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(!"".equals(forgetNumber.getText().toString().trim())){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            nextbut.setEnabled(true);
                            nextbut.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_or_reg_btn_able));
                        }
                    });
                }else{
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            nextbut.setEnabled(false);
                            nextbut.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_or_reg_btn_enable));
                        }
                    });
                }
            }
        }, 0, 100);
    }

    @OnClick({R.id.back, R.id.existing, R.id.forget_number, R.id.forget_newpass, R.id.nextbut, R.id.Tourist})
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

            case R.id.nextbut:
                if(isMobileNO(forgetNumber.getText().toString().trim())){
                    startActivity(new Intent(ForgetpwdActivity.this, ConfirmActivity.class));
                }else {
                    Toast.makeText(ForgetpwdActivity.this,"您输入的手机号格式不对",Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.Tourist:
                startActivity(new Intent(ForgetpwdActivity.this, MainActivity.class));
                ForgetpwdActivity.this.overridePendingTransition(R.anim.start_in, R.anim.start_out);
                break;
        }
    }
    //验证手机号是否正确ֻ
    public static boolean isMobileNO(String s) {
        Pattern p = Pattern.compile("^(13[0-9]|14[57]|15[0-35-9]|17[6-8]|18[0-9])[0-9]{8}$");
        Matcher m = p.matcher(s);
        return m.matches();
    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void OnSuccese(ForGetPwdBean forGetPwdBean) {
        Toast.makeText(ForgetpwdActivity.this, forGetPwdBean.getMsg(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onError(String s) {

    }
}
