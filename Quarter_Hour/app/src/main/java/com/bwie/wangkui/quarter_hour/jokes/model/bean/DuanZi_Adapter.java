package com.bwie.wangkui.quarter_hour.jokes.model.bean;

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

/**
 * Created by DELL on 2018/5/1.
 */

public class DuanZi_Adapter extends RecyclerView.Adapter<DuanZi_Adapter.MyHolder>{

    private Context context;
    private List<DuanZi.DataBean> list;

    public DuanZi_Adapter(Context context, List<DuanZi.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.duanzi_jokes,parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        DuanZi.DataBean.UserBean user = list.get(position).getUser();
        String nickname = (String) user.getNickname();
        if(nickname!=null){
            holder.tv1.setText(nickname);
        }else {
            holder.tv1.setText("渣渣辉");
        }
        Glide.with(context)
                .load(user.getIcon())
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .transform(new GlideCircleTransform(context))
                .crossFade()
                .into(holder.imageView);
        holder.tv2.setText(list.get(position).getCreateTime());
        holder.tv3.setText(list.get(position).getContent());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tv1,tv2,tv3;


        public MyHolder(View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.c_duanzi_img);
            tv1=itemView.findViewById(R.id.c_duanzi_name);
            tv2=itemView.findViewById(R.id.c_duanzi_sj);
            tv3=itemView.findViewById(R.id.c_duanzi_nr);

        }
    }

}
