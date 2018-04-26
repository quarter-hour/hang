package com.bwie.wangkui.quarter_hour.creation.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.wangkui.quarter_hour.R;
import com.bwie.wangkui.quarter_hour.creation.presenter.PushPresenter;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Article extends AppCompatActivity implements PushIview {

    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.push)
    TextView push;
    @BindView(R.id.inputtext)
    EditText inputtext;
    @BindView(R.id.all)
    ImageView all;
    @BindView(R.id.at)
    ImageView at;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.push, R.id.all, R.id.at})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back://点击取消
                finish();
                break;
            case R.id.push://点击发表
                muPush();
                break;
            case R.id.all://点击选择文件
                break;
            case R.id.at://@人
                break;
        }
    }

    /**
     * 发表文章
     * 1、获取文本内容 判断不为空
     * 2、进行网络请求
     */
    private void muPush() {
        String string = inputtext.getText().toString();
        //判断文本内容不能为空
        if("".equals(string)){
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("uid","12575");
            hashMap.put("content","123123123");
            hashMap.put("jokeFiles",null);
            hashMap.put("token","4ACD74F29724EF480ABC16698BA4476B");
            PushPresenter presenter = new PushPresenter(this);
            presenter.guanlian();


        }else{
            //提示用户
            Toast.makeText(this, "内容不能为空", Toast.LENGTH_SHORT).show();
        }
    }
   //段子发表成功
    @Override
    public void onSuccess(String string) {

    }
   //段子发表失败
    @Override
    public void onFail(String string) {

    }
}
