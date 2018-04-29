package com.bwie.wangkui.quarter_hour.video;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.wangkui.quarter_hour.R;
import com.bwie.wangkui.quarter_hour.video.fragment.Tab_Fragment1;
import com.bwie.wangkui.quarter_hour.video.fragment.Tab_Fragment2;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ThinkPad on 2018/4/24.
 */

public class Fragment3 extends Fragment {


    @BindView(R.id.video_tablayout)
    TabLayout mVideoTablayout;
    @BindView(R.id.video_viewpager)
    ViewPager mVideoViewpager;
    private View view;
    private Unbinder unbinder;
    String[] strings = {"热门","附近"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment3, null);

        unbinder = ButterKnife.bind(this, view);

        mVideoTablayout.setupWithViewPager(mVideoViewpager);
        mVideoTablayout.setTabMode(TabLayout.MODE_FIXED);
//设置标题
        for (int i = 0; i <strings.length ; i++) {
            mVideoTablayout.addTab(mVideoTablayout.newTab().setText(strings[i]));
        }

        //ViewPage适配器
        Tab_Fragment1 tab_fragment1 = new Tab_Fragment1();
        Tab_Fragment2 tab_fragment2 = new Tab_Fragment2();
        final List<Fragment> list = new ArrayList<>();
        list.add(tab_fragment1);
        list.add(tab_fragment2);

        mVideoViewpager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
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
                return strings[position];
            }
        });


        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
