package com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.callback;


import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.bean.BannerBean;
//获取banner数据的回调，负责把数据从model层传到presenter层
public interface BannerInModelCallBack{
    void onBannerInModelSuccess(BannerBean bannerBean);
    void onBannerInModelFail(String errorMessage);
}
