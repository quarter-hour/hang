package com.bwie.wangkui.quarter_hour.video.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.telecom.CallScreeningService;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.bwie.wangkui.quarter_hour.R;
import com.bwie.wangkui.quarter_hour.video.bean.ShowVideo_Bean;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.bumptech.glide.request.target.Target.SIZE_ORIGINAL;

/**
 * Created by dell on 2018/4/25.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    List<ShowVideo_Bean.DataBean> list;

    Context context;

    public MyAdapter(List<ShowVideo_Bean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.video_recyclerview_item,parent,false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int layoutPosition = myViewHolder.getLayoutPosition();
                listenner.setItemClick(layoutPosition);
            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

//        String icon = list.get(position).getUser().getIcon();
        String cover = list.get(position).getCover();

        int screenWidth = context.getResources().getDisplayMetrics().widthPixels;
    //Item的宽度，或图片的宽度
        int width = screenWidth/2;

        if (cover!=null&&!cover.equals("")){
            Glide.with(context).load(cover).override(width,Target.SIZE_ORIGINAL).into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.video_image);
        }
    }
    public interface setOnItemRecyclerViewListenner{
        void setItemClick(int position);
    }
    setOnItemRecyclerViewListenner listenner;

    public void setListenner(setOnItemRecyclerViewListenner listenner1){
        listenner = listenner1;
    }
}
