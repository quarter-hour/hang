package com.bwie.wangkui.quarter_hour.video.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwie.wangkui.quarter_hour.R;
import com.bwie.wangkui.quarter_hour.video.adapter.MyAdapter;
import com.bwie.wangkui.quarter_hour.video.bean.ShowVideo_Bean;
import com.bwie.wangkui.quarter_hour.video.presenter.ShowVideo_Presenter;
import com.bwie.wangkui.quarter_hour.video.view.ShowVideo_View;
import com.bwie.wangkui.quarter_hour.video.view.Video_show_video;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by dell on 2018/4/25.
 */

public class Tab_Fragment1 extends Fragment implements ShowVideo_View{
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
    //页码
    int page =1;
    private ShowVideo_Presenter showVideo_presenter;
    private List<ShowVideo_Bean.DataBean> data;
    private MyAdapter myAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.viedeo_tab_fragment1,container,false);

        //展示视频首页的方法
        showVideo_presenter = new ShowVideo_Presenter(this);
        showVideo_presenter.showVideo_present( page+"");

        unbinder = ButterKnife.bind(this, view);
        //瀑布流
//        mShowVideoXrecycleView.setLayoutManager(new StaggeredGridLayoutManager(0,StaggeredGridLayoutManager.VERTICAL));
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
    public void showVideoFail(String s) {

        Log.e("qqq", s);

    }

    @Override
    public void showVideoSuccess(final ShowVideo_Bean showVideo_bean) {

//        Toast.makeText(getContext(), ""+showVideo_bean.getCode()+showVideo_bean.getMsg(), Toast.LENGTH_SHORT).show();
        Log.e("aaa", showVideo_bean.getCode() + showVideo_bean.getMsg());
        //适配器
        if(page==1) {
            data = showVideo_bean.getData();
            myAdapter = new MyAdapter(data,getActivity());
            mShowVideoXrecycleView.setAdapter(myAdapter);
        }

        mShowVideoXrecycleView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
//                Toast.makeText(getActivity(), "刷新", Toast.LENGTH_SHORT).show();
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
//                Toast.makeText(getActivity(), "加载", Toast.LENGTH_SHORT).show();
                page++;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("page",page+"");
                       showVideo_presenter.showVideo_present( page+"");
                        List<ShowVideo_Bean.DataBean> data1 = showVideo_bean.getData();
                        data.addAll(data1);
                        myAdapter.notifyDataSetChanged();
                        mShowVideoXrecycleView.loadMoreComplete();

                    }
                },2000);
            }
        });

        myAdapter.setListenner(new MyAdapter.setOnItemRecyclerViewListenner() {
            @Override
            public void setItemClick(int position) {
                String videoUrl = data.get(position).getVideoUrl();
                String cover = data.get(position).getCover();
                String workDesc = data.get(position).getWorkDesc();
                Intent intent = new Intent(getActivity(), Video_show_video.class);
                Log.i("aaaurl",videoUrl);
                intent.putExtra("cover",cover);
                intent.putExtra("videourl",videoUrl);
                intent.putExtra("workDesc",workDesc);
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
