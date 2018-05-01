package com.bwie.wangkui.quarter_hour.user.view.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.wangkui.quarter_hour.MainActivity;
import com.bwie.wangkui.quarter_hour.MyApplication;
import com.bwie.wangkui.quarter_hour.R;
import com.bwie.wangkui.quarter_hour.user.model.bean.Login_Bean;
import com.bwie.wangkui.quarter_hour.user.presenter.Login_Presenter;
import com.bwie.wangkui.quarter_hour.user.view.Login_View;
import com.bwie.wangkui.quarter_hour.utils.SharedPreferancesUtil;

import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 点击其他登录 跳转到 登录页面
 */
public class LoginActivity extends AppCompatActivity implements Login_View {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.reg)
    TextView reg;
    @BindView(R.id.login_name)
    EditText login_name;
    @BindView(R.id.login_pwd)
    EditText login_pwd;
    @BindView(R.id.loginBtn)
    Button loginBtn;
    @BindView(R.id.forgetpwd)
    TextView forgetpwd;
    @BindView(R.id.Tourist)
    TextView Tourist;
    private SharedPreferences prefs;
    private Login_Presenter login_presenter;
    private Timer timer;
    private TextView xiu,yan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        hideActionBar();

        login_presenter = new Login_Presenter(this);
        prefs = MyApplication.getSp();

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(!"".equals(login_name.getText().toString().trim()) && !"".equals(login_pwd.getText().toString().trim())){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            loginBtn.setEnabled(true);
                            loginBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_or_reg_btn_able));

                        }
                    });
                }else{
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            loginBtn.setEnabled(false);
                            loginBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_or_reg_btn_enable));
                        }
                    });
                }
            }
        }, 0, 100);

    }

    @OnClick({R.id.back, R.id.reg, R.id.login_name, R.id.login_pwd, R.id.loginBtn, R.id.forgetpwd, R.id.Tourist})
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
            /*case R.id.login_name:
                break;
            case R.id.login_pwd:
                break;*/
            case R.id.loginBtn:
                //获取EdText的值
                String s = login_name.getText().toString();
                String s1 = login_pwd.getText().toString();
                if (s!=null && !"".equals(s) && null!=s1 && !"".equals(s1)){
                    login_presenter.getLoginPresenter(s, s1, this);
                }else{
                    Toast.makeText(LoginActivity.this,"用户名或密码不能为空!",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.forgetpwd:
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setSingleChoiceItems(new String[]{"修改密码","短信验证登录"}, -1, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface arg0, int arg1) {
                        switch (arg1) {
                            case 0:String.valueOf(1);
                            startActivity(new Intent(LoginActivity.this,ConfirmActivity.class));
                            break;
                            case 1:String.valueOf(2);
                                startActivity(new Intent(LoginActivity.this,ForgetpwdActivity.class));
                            break;
                            default: break;
                        }
                        arg0.dismiss();
                    }
                });
                builder.setNegativeButton("取消",null);
                builder.show();
                break;
            case R.id.Tourist:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                LoginActivity.this.overridePendingTransition(R.anim.start_in, R.anim.start_out);
                break;
        }
    }
    //验证密码是否正确ֻ
    public static final boolean isRightPwd(String pwd) {
        Pattern p = Pattern.compile("^(?![^a-zA-Z]+$)(?!\\D+$)[0-9a-zA-Z]{8,16}$");
        Matcher m = p.matcher(pwd);
        return m.matches();
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
    public void OnSuccese(Login_Bean login_bean) {
        Toast.makeText(LoginActivity.this, login_bean.getMsg(), Toast.LENGTH_SHORT).show();
        if("0".equals(login_bean.getCode())){
//            SharedPreferences.Editor edit = prefs.edit();
//            edit.putBoolean("isLogin", true);
//            edit.putString("token", login_bean.getData().getToken());
//            edit.putString("uid", login_bean.getData().getUid()+"");
//            edit.commit();
            SharedPreferancesUtil user = SharedPreferancesUtil.getSPInstance(LoginActivity.this, "User");
            user.put("token",login_bean.getData().getToken());
            user.put("uid",login_bean.getData().getUid());
            finish();
            SharedPreferancesUtil.getSPInstance(LoginActivity.this,"User").put("token",login_bean.getData().getToken());
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
        }
    }

    @Override
    public void onError(String s) {
        Log.i("---longin---",s.toString());
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR) {
            overridePendingTransition(R.anim.close_in, R.anim.close_out);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(timer != null){
            timer.cancel();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000 && resultCode == 2000){
            if(data.getStringExtra("login_name") != null && !"".equals(data.getStringExtra("login_name"))){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        login_name.setText(data.getStringExtra("login_name"));
                    }
                });
            }
        }
    }


}
