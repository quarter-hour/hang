package com.bwie.wangkui.quarter_hour.user.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.wangkui.quarter_hour.R;
import com.bwie.wangkui.quarter_hour.user.view.fragment.MyFragment01;
import com.bwie.wangkui.quarter_hour.user.view.fragment.MyFragment02;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyProductionActivity extends AppCompatActivity {

    @BindView(R.id.imageView5)
    ImageView imageView5;
    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vip)
    ViewPager vip;

    String[] title1={"本地作品","已上传"};
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_production);
        ButterKnife.bind(this);

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                MyProductionActivity.this.overridePendingTransition(R.anim.close_in, R.anim.close_out);
            }
        });
        //设置标题
        for (int i=0;i<title1.length;i++){
            tab.addTab(tab.newTab().setText(title1[i]));
        }
        list=new ArrayList<Fragment>();
        MyFragment01 myFragment01 =new MyFragment01();
        MyFragment02 myFragment02 = new MyFragment02();
        list.add(myFragment01);
        list.add(myFragment02);

        tab.setupWithViewPager(vip);
        vip.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return title1[position];
            }

        });
    }
}
