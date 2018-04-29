package com.bwie.wangkui.quarter_hour.recommend.recommend_model;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bwie.wangkui.quarter_hour.R;
import com.bwie.wangkui.quarter_hour.utils.GlideCircleTransform;

import java.util.List;


import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


/**
 * Created by DELL on 2018/4/26.
 */

public class Adapter_ReMen extends RecyclerView.Adapter<Adapter_ReMen.MyHolder>{

    private Context context;
    private List<ReMen_Bean.DataBean> list;
    private View view;

    public Adapter_ReMen(Context context, List<ReMen_Bean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.recommend_remen_xrlv,parent,false);
        MyHolder myHolder=new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {
        ReMen_Bean.DataBean.UserBean user = list.get(position).getUser();
        String cover = list.get(position).getVideoUrl();
        holder.tv1.setText(user.getNickname());
        holder.tv2.setText(list.get(position).getCreateTime());
        holder.tv3.setText(list.get(position).getWorkDesc());
        Glide.with(context)
                .load(user.getIcon())
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .transform(new GlideCircleTransform(context))
                .crossFade()
                .into(holder.imageView);


        holder.videoView.setUp(cover, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        JCVideoPlayerStandard videoView;
        TextView tv1,tv2,tv3;

        public MyHolder(View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.textView);
            tv2=itemView.findViewById(R.id.textView2);
            tv3=itemView.findViewById(R.id.textView3);
            imageView=itemView.findViewById(R.id.imageView);
            videoView=itemView.findViewById(R.id.videoView);
        }


    }

}
