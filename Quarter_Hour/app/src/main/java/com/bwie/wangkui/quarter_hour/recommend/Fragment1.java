package com.bwie.wangkui.quarter_hour.recommend;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bwie.wangkui.quarter_hour.R;
import com.bwie.wangkui.quarter_hour.recommend.recommend_view.GuanZhu_Fragment;
import com.bwie.wangkui.quarter_hour.recommend.recommend_view.ReMen_Fragment;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ThinkPad on 2018/4/24.
 */

public class Fragment1 extends Fragment {
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;

    private List<Fragment> list=new ArrayList<>();
    private ReMen_Fragment reMenFragment;
    private GuanZhu_Fragment guanZhuFragment;
    String title1[]={"热门","关注"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment1, null);
        unbinder = ButterKnife.bind(this, view);

        tabs.setupWithViewPager(vp);
        tabs.setTabMode(TabLayout.MODE_FIXED);

        for (int i=0;i<title1.length;i++){
            tabs.addTab(tabs.newTab().setText(title1[i]));
        }

        reMenFragment=new ReMen_Fragment();
        guanZhuFragment=new GuanZhu_Fragment();
        list.add(reMenFragment);
        list.add(guanZhuFragment);

        vp.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
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
        return view;
    }

    public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        tabs.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(tabs, 50, 50);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
