package com.bwie.wangkui.quarter_hour.creation.view;


import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.VideoView;

import com.bwie.wangkui.quarter_hour.R;
import com.bwie.wangkui.quarter_hour.creation.presenter.PushPresenter;
import com.bwie.wangkui.quarter_hour.creation.presenter.PushVideoPresenter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class Video extends AppCompatActivity implements PushVideoView {


    private Uri fromFile;
    private ProgressDialog dialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
       //开始录像
        statrtphoto();
    }

    private void statrtphoto() {
        //创建输出文件
        File file = new File(Environment.getExternalStorageDirectory(),"test.mp4");  //存放在sd卡的根目录下
        fromFile = Uri.fromFile(file);

        //生成Intent.
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fromFile);
        //启动摄像头应用程序
        startActivityForResult(intent, 999);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       if(data.getData()!=null){
           HashMap<String, String> hashMap = new HashMap<>();
           hashMap.put("uid", "12575");
           hashMap.put("latitude", "2312");
           hashMap.put("longitude", "213123");
           PushVideoPresenter presenter = new PushVideoPresenter(this);
          //视频文件
           List<MultipartBody.Part> listParts = new ArrayList<>();
           //通过file对象创建一个请求
               File file = new File(data.getData().getPath());
               RequestBody requestFile = RequestBody.create(MediaType.parse("application/otcet-stream"), file);
               //通过请求体对象 构建MultipartBody.Part对象
               //"file" 接口里面参数的名
               MultipartBody.Part part = MultipartBody.Part.createFormData("videoFile", file.getName(), requestFile);
               listParts.add(part);

           File file2 = new File("file://qq.jpg");
           //图片文件
           File file1 = new File("/storage/emulated/0/Pictures/Screenshots/Screenshot_2018-05-01-13-59-27.png");
           MultipartBody.Part body1 =MultipartBody.Part.createFormData("coverFile", file2.getName(), requestFile);
           listParts.add(body1);
           presenter.guanlian(hashMap,listParts);
           dialog();
       }

       }



    public void dialog(){
        dialog = new ProgressDialog(this);
        dialog.setMax(100);
        dialog.setTitle("视频上传中...");
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.show();

    }

    @Override
    public void Onsuccess(String string) {
          dialog.dismiss();
        Toast.makeText(this, "上传成功", Toast.LENGTH_SHORT).show();
        finish();
    }
}
