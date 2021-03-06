package com.bwie.wangkui.quarter_hour;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.wangkui.quarter_hour.jokes.Fragment2;
import com.bwie.wangkui.quarter_hour.recommend.Fragment1;
import com.bwie.wangkui.quarter_hour.user.DisanfangActivity;
import com.bwie.wangkui.quarter_hour.utils.API;
import com.bwie.wangkui.quarter_hour.utils.ApiService;
import com.bwie.wangkui.quarter_hour.utils.Bean;
import com.bwie.wangkui.quarter_hour.utils.RetrofitUtlis;
import com.bwie.wangkui.quarter_hour.video.Fragment3;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnbar)
    BottomTabBar btnbar;//底部导航
    @BindView(R.id.title)
    TextView title;//页面顶部标题
    @BindView(R.id.navigation_view)
    NavigationView navigationView;//侧滑扯淡
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;//页面总布局
    @BindView(R.id.fresco)
    SimpleDraweeView fresco;//主页面头像
    @BindView(R.id.main_content)
    LinearLayout mainContent;//页面布局
    private String[] arr = new String[]{"推荐", "段子", "视频", "关注"};//页面顶部标题数据
    private boolean flag = true;//判断侧滑栏是否打开或者关闭
    private SimpleDraweeView myhead;
    private TextView name;
    private ImageView sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();

    }

    /**
     * 页面点击事件 侧滑栏设置  侧滑栏点击事件
     */
    private void initView() {
        View view = navigationView.inflateHeaderView(R.layout.navigationview_head);
        myhead = view.findViewById(R.id.simpleDraweeView);//侧滑菜单头像
        name = view.findViewById(R.id.textView2);//姓名
        sex = view.findViewById(R.id.imageView);//性别图片

        myhead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "你点击了头偶像", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(MainActivity.this, DisanfangActivity.class));

            }
        });


        /**
         * Bottom_Bar
         * 底部导航栏  实现与fragment联动
         */
        btnbar.init(getSupportFragmentManager())
                .setFontSize(0)
                .addTabItem("", R.mipmap.tuijian2, R.mipmap.tuijian1, Fragment1.class)
                .addTabItem("", R.mipmap.duanzi2, R.mipmap.duanzi1, Fragment2.class)
                .addTabItem("", R.mipmap.shipin2, R.mipmap.shipin1, Fragment3.class)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                        title.setText(arr[position]);
                    }
                })
               .setDividerHeight(60)
                .setImgSize(100,100)
                .isShowDivider(false);
        /**
         * 点击头像打开侧滑栏
         */
        fresco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    drawerlayout.openDrawer(Gravity.LEFT);
                    flag = false;
                } else {
                    drawerlayout.closeDrawer(Gravity.LEFT);
                    flag = true;
                }
            }
        });
        /**
         * 侧滑监听  侧滑菜单出现和消失时，右侧布局跟着改变
         */
        drawerlayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //获取屏幕的宽高
                WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
                Display display = manager.getDefaultDisplay();
                //设置右面的布局位置  根据左面菜单的right作为右面布局的left   左面的right+屏幕的宽度（或者right的宽度这里是相等的）为右面布局的right
                mainContent.layout(navigationView.getRight(), 0, navigationView.getRight() + display.getWidth(), display.getHeight());
            }
            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        /**
         * 侧滑菜单中条目点击事件
         */
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_item_1:
                        Snackbar.make(drawerlayout,"你点击了我的关注",Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.navigation_item_2:
                        Snackbar.make(drawerlayout,"你点击了我的收藏",Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.navigation_item_3:
                        Snackbar.make(drawerlayout,"你点击了搜索好友",Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.navigation_item_4:
                        Snackbar.make(drawerlayout,"你点击了消息通知",Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.navigation_item_5:
                        Snackbar.make(drawerlayout,"你点击了夜间模式",Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.navigation_item_6:
                        Snackbar.make(drawerlayout,"你点击了我的作品",Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.navigation_item_7:
                        Snackbar.make(drawerlayout,"你点击了设置",Snackbar.LENGTH_LONG).show();
                        break;

                }
                return false;
            }
        });


    }

}
