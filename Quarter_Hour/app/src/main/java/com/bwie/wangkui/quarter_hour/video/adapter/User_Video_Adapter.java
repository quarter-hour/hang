package com.bwie.wangkui.quarter_hour.video.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bwie.wangkui.quarter_hour.R;
import com.bwie.wangkui.quarter_hour.video.bean.User_Video_Bean;

import java.util.List;

/**
 * Created by dell on 2018/4/27.
 */

public class User_Video_Adapter extends RecyclerView.Adapter<User_Video_Adapter.MyViewHolder>{
    List<User_Video_Bean.DataBean.WorksEntitiesBean> list;
    Context context;

    public User_Video_Adapter(List<User_Video_Bean.DataBean.WorksEntitiesBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.user_video_item,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Glide.with(context).load(list.get(position).getCover()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.user_image_item);
        }
    }


}
