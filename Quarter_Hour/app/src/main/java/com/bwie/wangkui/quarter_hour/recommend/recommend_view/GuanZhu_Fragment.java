package com.bwie.wangkui.quarter_hour.recommend.recommend_view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.wangkui.quarter_hour.R;
import com.bwie.wangkui.quarter_hour.recommend.recommend_model.Adapter_ReMen;
import com.bwie.wangkui.quarter_hour.recommend.recommend_model.ReMen_Bean;
import com.bwie.wangkui.quarter_hour.recommend.recommend_presenter.ReMen_Presenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by DELL on 2018/4/25.
 */

public class GuanZhu_Fragment extends Fragment implements ReMen_View{

    @BindView(R.id.xrlv)
    XRecyclerView xrlv;
    Unbinder unbinder;
    ReMen_Presenter reMenPresenter;
    private int page=1;
    private List<ReMen_Bean.DataBean> data;
    private Adapter_ReMen adapterReMen;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recommend_remen, container, false);
        reMenPresenter=new ReMen_Presenter(this);
        reMenPresenter.relance(page+"");
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
    public void success(ReMen_Bean reMenBean) {
        data = reMenBean.getData();
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrlv.setLayoutManager(layoutManager);
        adapterReMen=new Adapter_ReMen(getActivity(),data);

        xrlv.setAdapter(adapterReMen);
    }
}
