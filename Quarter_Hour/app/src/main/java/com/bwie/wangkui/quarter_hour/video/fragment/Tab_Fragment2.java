package com.bwie.wangkui.quarter_hour.video.fragment;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwie.wangkui.quarter_hour.R;
import com.bwie.wangkui.quarter_hour.utils.LocationUtils;
import com.bwie.wangkui.quarter_hour.video.bean.VicinityBean;
import com.bwie.wangkui.quarter_hour.video.presenter.Vicinty_Presenter;
import com.bwie.wangkui.quarter_hour.video.view.Vicinty_View;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by dell on 2018/4/25.
 */

public class Tab_Fragment2 extends Fragment implements Vicinty_View {

    int page = 1;
    @BindView(R.id.showVideo_xrecycleView)
    XRecyclerView mShowVideoXrecycleView;
    private View view;
    private Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viedeo_tab_fragment1, container, false);
        Location location = LocationUtils.getInstance(getActivity()).showLocation();
      //  double latitude = location.getLatitude();
      //  double longitude = location.getLongitude();
        if (location != null) {
            String address = "纬度：" + location.getLatitude() + "经度：" + location.getLongitude();
            Log.d("FLY.LocationUtils", address);
            Log.i("aqa", address);
        }

        new Vicinty_Presenter(this).vicintyPresenter(page + "", 1 + "", 1 + "");

        unbinder = ButterKnife.bind(this, view);
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);

        mShowVideoXrecycleView.setLayoutManager(layoutManager);
//        防止item 交换位置
        mShowVideoXrecycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                //防止第一行到顶部有空白区域
                layoutManager.invalidateSpanAssignments();
            }
        });
        return view;
    }

    @Override
    public void vicinty_videoFail(String s) {

    }

    @Override
    public void vicinty_videoSuccess(VicinityBean vicinityBean) {

        Toast.makeText(getActivity(), "" + vicinityBean.getCode() + "", Toast.LENGTH_SHORT).show();

        List<VicinityBean.DataBean> data = vicinityBean.getData();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
