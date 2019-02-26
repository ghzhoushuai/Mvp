package com.lingtu.zhoushuai.demo3formvp.base;

import android.content.Context;

/*
* 至于为什么不把onSuccess()方法也封装，是因为请求网络，服务器返回的值是不一样的，在Contract > View接口中根据bean类设置onSuccess()
* */
public interface BaseView {
    /**
     * 显示加载中
     */
    void showLoading();

    /**
     * 隐藏加载
     */
    void hideLoading();

    /**
     *
     * @return
     */
    Context getContext();
}
