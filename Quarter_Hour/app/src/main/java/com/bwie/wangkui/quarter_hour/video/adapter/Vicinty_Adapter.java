package com.bwie.wangkui.quarter_hour.video.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bwie.wangkui.quarter_hour.R;
import com.bwie.wangkui.quarter_hour.video.bean.VicinityBean;

import java.util.List;

import static com.bumptech.glide.request.target.Target.SIZE_ORIGINAL;

/**
 * Created by dell on 2018/4/26.
 */

public class Vicinty_Adapter extends RecyclerView.Adapter<Vicinty_Adapter.MyViewHolder>{

    List<VicinityBean.DataBean> list;
    Context context;

    public Vicinty_Adapter(List<VicinityBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vicinty_recycleview_item,parent,false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int layoutPosition = myViewHolder.getLayoutPosition();
                recyclerclick.serOnRecyclerclickListenner(layoutPosition);
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String icon = list.get(position).getUser().getIcon();

        int screenWidth = context.getResources().getDisplayMetrics().widthPixels;
        //Item的宽度，或图片的宽度
        int width = screenWidth/2;

        Glide.with(context).load(icon).override(width,SIZE_ORIGINAL).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.vicinty_image);
        }
    }
    public interface onRecyclerclick{
        void serOnRecyclerclickListenner(int position);
    }
    onRecyclerclick recyclerclick;

    public void onItemclickListenner(onRecyclerclick onRecyclerclick){
        recyclerclick = onRecyclerclick;
    }
}
