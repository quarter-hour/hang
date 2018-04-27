package com.bwie.wangkui.quarter_hour.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.bwie.wangkui.quarter_hour.MyApplication;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import butterknife.internal.Utils;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.platform.Platform;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by dell on 2018/4/24.
 */

public class RetrofitUtlis {
    private static final String TAG = "RetrofitUtil";
    private static RetrofitUtlis retrofitUtil;
    private static OkHttpClient okHttpClient;
    private static String URL;

    static {
        getOkHttpClient();
    }

    private final Retrofit retrofit;

    public static RetrofitUtlis getInstance(String url) {
        Log.d(TAG, "getInstance: " + "retrofit");
        URL = url;
        if (retrofitUtil == null) {
            synchronized (RetrofitUtlis.class) {
                if (retrofitUtil == null) {
                    retrofitUtil = new RetrofitUtlis();

                }
            }
        }
        return retrofitUtil;
    }

    public <T> T getApiService(Class<T> service) {
        return retrofit.create(service);
    }

    public static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            synchronized (OkHttpClient.class) {
                if (okHttpClient == null) {
                    okHttpClient = new OkHttpClient.Builder()
                            .addInterceptor(new MyIntercepter())
                            .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))//日志拦截器
                            .build();
                }
            }
        }
        return okHttpClient;
    }

    private RetrofitUtlis() {
        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

    }

    //拦截器

    public static class MyIntercepter implements Interceptor {
        private final String TAG = "respond";
        private int versionCode;

        @Override
        public Response intercept(Chain chain) throws IOException {
            SharedPreferences sp = MyApplication.getSp();
            SharedPreferancesUtil user = SharedPreferancesUtil.getSPInstance(MyApplication.myApplication, "User");
            String token = (String) user.getSharedPreference("token", "4ACD74F29724EF480ABC16698BA4476B");
            Request request = chain.request();
            Request.Builder request_builder = request.newBuilder();
            System.out.println(request.method() + "开始添加公共参数222222222");
            //            String token = (String) SharePrefrenceUtils.getData(SharePrefrenceBack.String, "token");
            try {
                Context context = MyApplication.myApplication;
                PackageManager pm = context.getPackageManager();
                PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
                versionCode = pi.versionCode;
                System.out.println("versionCode============" + versionCode);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            if ("GET".equals(request.method())) {
                HttpUrl.Builder builder = request.url().newBuilder();
                HttpUrl build = builder.addQueryParameter("source", "android")
                        .addQueryParameter("appVersion", "101")
                        .addQueryParameter("token", token + "")
                        .build();
                request = request_builder.url(build).build();

            }

            if ("POST".equals(request.method())) {
                System.out.println(request.method() + "开始添加公共参数3333333333" + request.body().toString());
                if (request.body() instanceof FormBody) {
                    System.out.println("FormBody开始添加公共参数");
                    FormBody.Builder builder = new FormBody.Builder();
                    FormBody body = (FormBody) request.body();

                    for (int i = 0; i < body.size(); i++) {
                        builder.add(body.encodedName(i), body.encodedValue(i));
                    }

                    body = builder.add("source", "android")
                            .add("appVersion", String.valueOf(versionCode))
                            //                            .add("token", token+"")
                            .build();
                    System.out.println("开始添加公共参数55555");
                    request = request_builder.post(body).build();

                } else if (request.body() instanceof MultipartBody) {
                    System.out.println("MultipartBody开始添加公共参数");
                    MultipartBody body = (MultipartBody) request.body();
                    MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
                    builder.addFormDataPart("source", "android")
                            .addFormDataPart("appVersion", "101")
                            .addFormDataPart("token", token + "")
                            .build();
                    List<MultipartBody.Part> parts = body.parts();
                    for (MultipartBody.Part part : parts) {
                        builder.addPart(part);
                    }
                    request = request_builder.post(builder.build()).build();
                }
            }

            System.out.println("开始添加公共参数44444444444" + chain.proceed(request).body().string());

            return chain.proceed(request);

        }

        /**
         * 添加公共参数
         *
         * @param oldRequest
         * @return
         */
        private Request addParam(Request oldRequest) {

           /* String token = (String) SharePrefrenceUtils.getData(SharePrefrenceBack.String, "token");
            PackageInfo packageArchiveInfo = MyApp.app.getPackageManager().getPackageArchiveInfo(MyApp.app.getPackageName(), 0);
            int versionCode = packageArchiveInfo.versionCode;*/

            HttpUrl.Builder builder = oldRequest.url()
                    .newBuilder()
                    .setEncodedQueryParameter("source", "android")
                    //                    .setEncodedQueryParameter("token",token)
                    .setEncodedQueryParameter("appVersion", versionCode + "");

            Request newRequest = oldRequest.newBuilder()
                    .method(oldRequest.method(), oldRequest.body())
                    .url(builder.build())
                    .build();

            return newRequest;
        }


    }
}
