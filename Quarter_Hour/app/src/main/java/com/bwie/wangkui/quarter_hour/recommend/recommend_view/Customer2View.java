package com.bwie.wangkui.quarter_hour.recommend.recommend_view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.wangkui.quarter_hour.MyApplication;
import com.bwie.wangkui.quarter_hour.R;
import com.bwie.wangkui.quarter_hour.recommend.recommend_model.ShouCang;
import com.bwie.wangkui.quarter_hour.recommend.recommend_presenter.Sc_Presenter;

/**
 * Created by DELL on 2018/4/27.
 */

public class Customer2View extends RelativeLayout implements Sc_View{
    private ImageView imageView6;
    private ImageView imageView8;
    private ImageView imageView9;
    private ImageView imageView10;
    private ImageView imageView11;
    private ImageView imageView12;
    private View contentView;
    PopupWindow popupWindow;
    private Sc_Presenter sc_presenter;
    private String msg;


    public Customer2View(Context context) {
        super(context);
    }

    @SuppressLint("CommitPrefEdits")
    public Customer2View(final Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.customer2, this, false);
        imageView6 = view.findViewById(R.id.imageView6);
        imageView8 = view.findViewById(R.id.imageView8);
        imageView9 = view.findViewById(R.id.imageView9);
        imageView10 = view.findViewById(R.id.imageView10);
        imageView11= view.findViewById(R.id.imageView11);
        imageView12= view.findViewById(R.id.imageView12);
        //默认隐藏
        imageView8.setVisibility(View.INVISIBLE);
        imageView10.setVisibility(View.INVISIBLE);
        SharedPreferences sp = MyApplication.getSp();
        String wid = sp.getString("wid", null);
        sc_presenter=new Sc_Presenter(this);
        sc_presenter.relance(wid,"63EEA35975840ED338A46C0DC9F3D5D1");


        //点击显示
        imageView6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView6.setVisibility(INVISIBLE);
                imageView8.setVisibility(VISIBLE);
            }
        });

        imageView8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView6.setVisibility(VISIBLE);
                imageView8.setVisibility(INVISIBLE);
            }
        });

        imageView9.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //收藏视频
                Toast.makeText(getContext(), ""+msg, Toast.LENGTH_SHORT).show();
                imageView9.setVisibility(INVISIBLE);
                imageView10.setVisibility(VISIBLE);
            }
        });
        imageView10.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                imageView10.setVisibility(INVISIBLE);
                imageView9.setVisibility(VISIBLE);

                
            }
        });
        // 用于PopupWindow的View
        contentView = View.inflate(context, R.layout.recommend_xiahua,null);
        imageView11.setOnClickListener(new OnClickListener() {


            @Override
            public void onClick(View view) {
                popupWindow= new PopupWindow(contentView,750,300,true);
                // 设置PopupWindow是否能响应点击事件
                popupWindow.setTouchable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                popupWindow.setOutsideTouchable(false);
                popupWindow.showAsDropDown(imageView12,200,-30);
                initUI();
            }
        });



        addView(view);
    }

    private void initUI() {

        ImageView qq=contentView.findViewById(R.id.qq);
        ImageView qq_kj=contentView.findViewById(R.id.qq_kj);
        ImageView peny=contentView.findViewById(R.id.pengy);
        ImageView weixin=contentView.findViewById(R.id.weix);
        TextView quxiao=contentView.findViewById(R.id.quxiao);

        qq.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "点击了QQ", Toast.LENGTH_SHORT).show();
            }
        });

        quxiao.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });

    }

    public Customer2View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private OnClickListener  itemsOnClick = new OnClickListener(){

        @Override
        public void onClick(View view) {

        }
    };

    @Override
    public void filure(String s) {
        
    }

    @Override
    public void success(ShouCang shouCang) {
        msg = shouCang.getMsg();
    }
}
