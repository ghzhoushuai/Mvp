package com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.callback;

import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.bean.ArticleListBean;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.bean.BannerBean;

//获取Article数据的回调，负责把数据从model层传到presenter层
public interface ArticleInModelCallBack {
    void onArticleInModelSuccess(ArticleListBean articleListBean);
    void onArticleInModelFail(String errorMessage);
}
