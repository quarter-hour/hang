package com.bwie.wangkui.quarter_hour.video.fragment;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import com.bwie.wangkui.quarter_hour.video.adapter.Vicinty_Adapter;
import com.bwie.wangkui.quarter_hour.video.bean.ShowVideo_Bean;
import com.bwie.wangkui.quarter_hour.video.bean.VicinityBean;
import com.bwie.wangkui.quarter_hour.video.presenter.Vicinty_Presenter;
import com.bwie.wangkui.quarter_hour.video.view.Vicinty_View;
import com.bwie.wangkui.quarter_hour.video.view.Video_show_video;
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
    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    private Vicinty_Presenter vicinty_presenter;
    private double latitude,longitude;
    private List<VicinityBean.DataBean> data;
    private Vicinty_Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viedeo_tab_fragment1, container, false);
        Location location = LocationUtils.getInstance(getActivity()).showLocation();
      //  double latitude = location.getLatitude();
      //  double longitude = location.getLongitude();
        latitude = location.getLatitude();
         longitude = location.getLongitude();

      //  double latitude = location.getLatitude();
      //  double longitude = location.getLongitude();

        latitude = location.getLatitude();
        longitude = location.getLongitude();

        if (location != null) {
            String address = "纬度：" + location.getLatitude() + "经度：" + location.getLongitude();
            Log.d("FLY.LocationUtils", address);
            Log.i("aqa", address);
        }


        vicinty_presenter = new Vicinty_Presenter(this);
        vicinty_presenter.vicintyPresenter(page + "", latitude + "", longitude + "");

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
    public void vicinty_videoSuccess(final VicinityBean vicinityBean) {
        Log.i("log",vicinityBean.getCode() + "");
        Toast.makeText(getActivity(), "" + vicinityBean.getCode() + "", Toast.LENGTH_SHORT).show();
        if (page==1) {
            data = vicinityBean.getData();

            adapter = new Vicinty_Adapter(data, getActivity());

            mShowVideoXrecycleView.setAdapter(adapter);
        }

        mShowVideoXrecycleView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                page=1;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mShowVideoXrecycleView.refreshComplete();
                    }
                },2000);
            }

            @Override
            public void onLoadMore() {

                page++;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("page",page+"");
                        vicinty_presenter.vicintyPresenter(page+"",latitude+"",longitude+"");
                        List<VicinityBean.DataBean> data1 = vicinityBean.getData();
                        data.addAll(data1);
                        adapter.notifyDataSetChanged();
                        mShowVideoXrecycleView.loadMoreComplete();

                    }
                },2000);
            }
        });




        adapter.onItemclickListenner(new Vicinty_Adapter.onRecyclerclick() {
            @Override
            public void serOnRecyclerclickListenner(int position) {

                int wid = data.get(position - 1).getWid();
                Intent intent = new Intent(getActivity(), Video_show_video.class);
                intent.putExtra("wid",wid);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
