package com.bwie.wangkui.quarter_hour.video.fragment;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.wangkui.quarter_hour.MainActivity;
import com.bwie.wangkui.quarter_hour.R;
import com.bwie.wangkui.quarter_hour.utils.LocationUtils;

/**
 * Created by dell on 2018/4/25.
 */

public class Tab_Fragment2 extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viedeo_tab_fragment1,container,false);
        Location location = LocationUtils.getInstance( getActivity() ).showLocation();
        if (location != null) {
            String address = "纬度：" + location.getLatitude() + "经度：" + location.getLongitude();
            Log.d( "FLY.LocationUtils", address );
            Log.i("aqa",address);
        }
        return view;
    }
}
