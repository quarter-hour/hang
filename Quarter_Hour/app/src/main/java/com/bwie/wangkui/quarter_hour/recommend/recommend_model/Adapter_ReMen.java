package com.bwie.wangkui.quarter_hour.recommend.recommend_model;

import android.animation.ObjectAnimator;
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
    boolean b=true;

    public Adapter_ReMen(Context context, List<ReMen_Bean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recommend_remen_xrlv,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {
        ReMen_Bean.DataBean.UserBean user = list.get(position).getUser();
        String cover = list.get(position).getVideoUrl();
        holder.tv1.setText("渣渣辉");
        holder.tv2.setText(list.get(position).getCreateTime());
        holder.tv3.setText(list.get(position).getWorkDesc());
        Glide.with(context)
                .load(user.getIcon())
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .transform(new GlideCircleTransform(context))
                .crossFade()
                .into(holder.imageView);
        holder.videoView.setUp(cover, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");
        //属性动画
        holder.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b){
                    b=false;
                    ObjectAnimator animator = ObjectAnimator.ofFloat(holder.image3, "alpha", 1f, 0f, 1f);
                    animator.setDuration(1000);//时间1s
                    animator.start();
                    ObjectAnimator animator2 = ObjectAnimator.ofFloat(holder.image3, "rotation", 0f, 360f, 0f);
                    animator2.setDuration(1000);
                    animator2.start();
                    ObjectAnimator animator3 = ObjectAnimator.ofFloat(holder.image3, "translationX", 0f, -170f);
                    animator3.setDuration(1000);
                    animator3.start();
                    ObjectAnimator ani1 = ObjectAnimator.ofFloat(holder.image4, "alpha", 1f, 0f, 1f);
                    ani1.setDuration(1000);//时间1s
                    ani1.start();
                    ObjectAnimator ani2 = ObjectAnimator.ofFloat(holder.image4, "rotation", 0f, 360f, 0f);
                    ani2.setDuration(1000);
                    ani2.start();
                    ObjectAnimator ani3 = ObjectAnimator.ofFloat(holder.image4, "translationX", 0f, -320f);
                    ani3.setDuration(1000);
                    ani3.start();
                    ObjectAnimator anim1 = ObjectAnimator.ofFloat(holder.image5, "alpha", 1f, 0f, 1f);
                    anim1.setDuration(1000);//时间1s
                    anim1.start();
                    ObjectAnimator anim2 = ObjectAnimator.ofFloat(holder.image5, "rotation", 0f, 360f, 0f);
                    anim2.setDuration(1000);
                    anim2.start();
                    ObjectAnimator anim3 = ObjectAnimator.ofFloat(holder.image5, "translationX", 0f, -470f);
                    anim3.setDuration(1000);
                    anim3.start();
                }else {
                    b=true;
                    ObjectAnimator animator = ObjectAnimator.ofFloat(holder.image3, "alpha", 1f, 0f);
                    animator.setDuration(1000);//时间1s
                    animator.start();
                    ObjectAnimator animator2 = ObjectAnimator.ofFloat(holder.image3, "rotation", 0f, 360f, 0f);
                    animator2.setDuration(1000);
                    animator2.start();
                    ObjectAnimator animator3 = ObjectAnimator.ofFloat(holder.image3, "translationX", -170f, 0f);
                    animator3.setDuration(1000);
                    animator3.start();
                    ObjectAnimator ani1 = ObjectAnimator.ofFloat(holder.image4, "alpha", 1f, 0f);
                    ani1.setDuration(1000);//时间1s
                    ani1.start();
                    ObjectAnimator ani2 = ObjectAnimator.ofFloat(holder.image4, "rotation", 0f, 360f, 0f);
                    ani2.setDuration(1000);
                    ani2.start();
                    ObjectAnimator ani3 = ObjectAnimator.ofFloat(holder.image4, "translationX", -320f, 0f);
                    ani3.setDuration(1000);
                    ani3.start();
                    ObjectAnimator anim1 = ObjectAnimator.ofFloat(holder.image5, "alpha", 1f, 0f);
                    anim1.setDuration(1000);//时间1s
                    anim1.start();
                    ObjectAnimator anim2 = ObjectAnimator.ofFloat(holder.image5, "rotation", 0f, 360f, 0f);
                    anim2.setDuration(1000);
                    anim2.start();
                    ObjectAnimator anim3 = ObjectAnimator.ofFloat(holder.image5, "translationX", -470f, 0f);
                    anim3.setDuration(1000);
                    anim3.start();
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        ImageView imageView,imageView2,image3,image4,image5;
        JCVideoPlayerStandard videoView;
        TextView tv1,tv2,tv3;

        public MyHolder(View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.textView);
            tv2=itemView.findViewById(R.id.textView2);
            tv3=itemView.findViewById(R.id.textView3);
            imageView=itemView.findViewById(R.id.imageView);
            videoView=itemView.findViewById(R.id.videoView);
            imageView2=itemView.findViewById(R.id.imageView3);
            image3=itemView.findViewById(R.id.imageView4);
            image4=itemView.findViewById(R.id.imageView5);
            image5=itemView.findViewById(R.id.imageView6);
        }


    }

    public void anima1(){


    }

    public void anima2() {



    }
}
