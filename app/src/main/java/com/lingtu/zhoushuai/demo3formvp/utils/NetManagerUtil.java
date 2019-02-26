package com.lingtu.zhoushuai.demo3formvp.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/*
* 网络请求
* */
public class NetManagerUtil {
    public static final int TIMEOUT = 30 * 1000;
    public static final String BaseUrl = "http://www.wanandroid.com";

    //1.初始化okhttp设置
    public static OkHttpClient httpClient= new OkHttpClient.Builder()

            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build();


    //2.初始化retfofit
    private static Retrofit retrofit=new Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();


    //获得单例
    public static Retrofit getInstance(){
        return retrofit;
    }
}
