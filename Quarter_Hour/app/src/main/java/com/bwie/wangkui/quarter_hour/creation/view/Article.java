package com.bwie.wangkui.quarter_hour.creation.view;

import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bwie.wangkui.quarter_hour.R;
import com.bwie.wangkui.quarter_hour.creation.presenter.PushPresenter;
import com.bwie.wangkui.quarter_hour.utils.L;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.wangyi.imagepicker.ImagePicker;
import me.wangyi.imagepicker.ui.ImagePickerActivity;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

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
    @BindView(R.id.imageView2)
    ImageView imageView2;
    private File file;
    private String path;
    private File file1;
    private ArrayList<me.wangyi.imagepicker.model.Image> list;

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
                choosePhoto();
                break;
            case R.id.at://@人
                break;
        }
    }

    /**
     * 发表文章
     * 1、获取文本内容 判断不为空
     * 判断是是否选中了多图片
     * 2、进行网络请求
     */
    private void muPush() {
        String string = inputtext.getText().toString();
        //判断文本内容不能为空
        if (!"".equals(string) & null != string) {
            //判断文件是否为空
            if(list.size()<=0) {
                Toast.makeText(this, "没有选择文件", Toast.LENGTH_SHORT).show();
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("uid", "12575");
                hashMap.put("content", "罩得住");
                PushPresenter presenter = new PushPresenter(this);
                presenter.guanlian(hashMap,null);
            }else{
                Toast.makeText(this, "选择了图片文件", Toast.LENGTH_SHORT).show();
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("uid", "12575");
                hashMap.put("content", string);
                PushPresenter presenter = new PushPresenter(this);
                List<MultipartBody.Part> listParts = new ArrayList<>();
                //通过file对象创建一个请求
                for (int i=0;i<list.size();i++){
                    String path = list.get(i).getPath();
                    File file = new File(path);
                    RequestBody requestFile = RequestBody.create(MediaType.parse("application/otcet-stream"),file );
                    //通过请求体对象 构建MultipartBody.Part对象
                    //"file" 接口里面参数的名
                    MultipartBody.Part part = MultipartBody.Part.createFormData("jokeFiles",file.getName(), requestFile);
                    listParts.add(part);
                }
                presenter.guanlian(hashMap,listParts);
            }
        } else {
            //提示用户
            Toast.makeText(this, "内容不能为空", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 打开相册
     *
     */
    private void choosePhoto() {
        /**
         * 第三方图片选择
         */
        new ImagePicker()
                .mode(ImagePicker.MODE_MULTI_SELECT)
                .imageLoader(new MyImageLoader())
                .selectLimit(9)//最多选择图片数量
                .requestCode(0)
                .start(this);
        /**
         * 系统图库
         */
//        Intent intentToPickPic = new Intent(Intent.ACTION_PICK, null);
//        // 如果限制上传到服务器的图片类型时可以直接写如："image/jpeg 、 image/png等的类型" 所有类型则写 "image/*"
//        intentToPickPic.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
//        startActivityForResult(intentToPickPic, 0);
    }
    /**
     * 图片文件转换
     */
    public void update() {

    }

    //段子发表成功
    @Override
    public void onSuccess(String string) {

    }

    //段子发表失败
    @Override
    public void onFail(String string) {

    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK) {
            list = data.getParcelableArrayListExtra(ImagePicker.EXTRA_IMAGE_LIST);

           /* //得到返回图片的url
            Uri data1 = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            //从系统表中查询指定Uri对应的照片
            Cursor cursor = getContentResolver().query(data1, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            path = cursor.getString(columnIndex);
            cursor.close();
            file1 = new File(path);*/

        }
    }




}
     class MyImageLoader implements ImagePicker.ImageLoader {
        public void displayImage(ImageView imageView, Image image) {

    }

         @Override
         public void displayImage(ImageView imageView, me.wangyi.imagepicker.model.Image image) {
             Glide.with(imageView.getContext())
                     .load(image.getPath())
                     .dontAnimate()
                     .placeholder(R.mipmap.ic_launcher)
                     .into(imageView);
         }
     }