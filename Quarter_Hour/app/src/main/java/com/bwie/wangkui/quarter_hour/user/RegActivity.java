package com.bwie.wangkui.quarter_hour.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.wangkui.quarter_hour.MainActivity;
import com.bwie.wangkui.quarter_hour.R;
import com.bwie.wangkui.quarter_hour.user.model.bean.Reg_Bean;
import com.bwie.wangkui.quarter_hour.user.presenter.Reg_Presenter;
import com.bwie.wangkui.quarter_hour.user.view.Reg_View;
import com.bwie.wangkui.quarter_hour.utils.API;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 点击注册账号 跳转到 注册页面
 */
public class RegActivity extends AppCompatActivity implements Reg_View {

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
    private Reg_Presenter reg_presenter;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        ButterKnife.bind(this);
        hideActionBar();

        reg_presenter = new Reg_Presenter(this);
        timer = new Timer();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                View view = View.inflate(RegActivity.this, R.layout.reg_hint, null);
                final PopupWindow popupWindow = new PopupWindow(RegActivity.this);
                view.findViewById(R.id.sure).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                if(!"".equals(regName.getText().toString().trim()) && !"".equals(regPwd.getText().toString().trim())){
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            regbut.setEnabled(true);
                                            regbut.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_or_reg_btn_able));
                                        }
                                    });
                                }else{
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            regbut.setEnabled(false);
                                            regbut.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_or_reg_btn_enable));
                                        }
                                    });
                                }
                            }
                        }, 0, 100);
                    }
                });
                view.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                        finish();
                    }
                });
                popupWindow.setContentView(view);
                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
                popupWindow.showAtLocation(View.inflate(RegActivity.this, R.layout.activity_reg, null), Gravity.BOTTOM, 0, 0);
            }
        }, 100);

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
            case R.id.regbut:
                String s = regName.getText().toString();
                String s1 = regPwd.getText().toString();
                if (s!=null && !"".equals(s) && null!=s1 && !"".equals(s1)){
                    reg_presenter.getRetPresenter(s, s1, this);
                }else{
                    Toast.makeText(RegActivity.this,"用户名或密码不能为空!",Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.Tourist:
                startActivity(new Intent(RegActivity.this, MainActivity.class));
                RegActivity.this.overridePendingTransition(R.anim.start_in, R.anim.start_out);
                break;
        }
    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void OnSuccese(final Reg_Bean reg_bean) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(RegActivity.this, reg_bean.getMsg(), Toast.LENGTH_SHORT).show();
                if ("0".equals(reg_bean.getCode())){
                    Intent data = new Intent();
                    data.putExtra("reg_name", regName.getText().toString());
                    setResult(2000, data);
                    finish();
                }
            }
        });
    }

    @Override
    public void onError(String s) {

    }
    /**
     * hide action bar
     */
    private void hideActionBar() {
        // Hide UI
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        overridePendingTransition(R.anim.close_in, R.anim.close_out);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(timer != null){
            timer.cancel();
        }
    }
}
