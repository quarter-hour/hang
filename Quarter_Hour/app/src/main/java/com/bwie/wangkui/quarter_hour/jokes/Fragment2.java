package com.bwie.wangkui.quarter_hour.jokes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.wangkui.quarter_hour.R;
import com.bwie.wangkui.quarter_hour.jokes.model.bean.DuanZi;
import com.bwie.wangkui.quarter_hour.jokes.model.bean.DuanZi_Adapter;
import com.bwie.wangkui.quarter_hour.jokes.presenter.Dz_Presenter;
import com.bwie.wangkui.quarter_hour.jokes.view.Dz_View;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ThinkPad on 2018/4/24.
 */

public class Fragment2 extends Fragment implements Dz_View{
    @BindView(R.id.xrlv2)
    XRecyclerView xrlv2;
    Unbinder unbinder;
    private List<DuanZi.DataBean> data;
    private Dz_Presenter dz_presenter;
    int page=1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment2, null);

        dz_presenter=new Dz_Presenter(this);
        dz_presenter.relance(page+"","3252");
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void filure(String s) {

    }

    @Override
    public void success(DuanZi duanZi) {
        data = duanZi.getData();
        Log.e("TAG",data.size()+"");
        xrlv2.setLayoutManager(new LinearLayoutManager(getActivity()));
        DuanZi_Adapter adapter=new DuanZi_Adapter(getActivity(),data);
        xrlv2.setAdapter(adapter);

    }
}
