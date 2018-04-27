package com.bwie.wangkui.quarter_hour.user.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.wangkui.quarter_hour.R;
import com.bwie.wangkui.quarter_hour.user.model.bean.FocusBean;

import java.util.List;

/**
 * Created by dell on 2018/4/27.
 */

public class FocusAdapter extends RecyclerView.Adapter<FocusAdapter.MyViewHolder>{

    List<FocusBean.DataBean> list;
    Context context;

    public FocusAdapter(List<FocusBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.focus_item,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.textView1.setText(list.get(position).getUsername());
        holder.textView2.setText(list.get(position).getCreatetime()+"");
        Glide.with(context).load(list.get(position).getIcon()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView1,textView2;
        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.focus_textview);
            textView2 = itemView.findViewById(R.id.focus_textview2);
            imageView = itemView.findViewById(R.id.focus_image);
        }
    }
}
