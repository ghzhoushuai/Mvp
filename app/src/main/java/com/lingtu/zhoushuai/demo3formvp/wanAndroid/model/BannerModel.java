package com.lingtu.zhoushuai.demo3formvp.wanAndroid.model;


import android.util.Log;

import com.lingtu.zhoushuai.demo3formvp.Api.RetroifitServiceApi;


import com.lingtu.zhoushuai.demo3formvp.utils.NetManagerUtil;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.bean.ArticleListBean;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.bean.BannerBean;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.callback.ArticleInModelCallBack;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.callback.BannerInModelCallBack;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class BannerModel {

    private CompositeDisposable cd=new CompositeDisposable();

    public void doDispose(){
        cd.clear();
    }

    //获取banner数据的网络请求
    //这里是没有请求参数的，有请求参数的话应该要这么写：
    //public void getLoginInModel(BaseCallBack baseCallBack,LoginRequestBody loginRequestBody)
    public void getBannerInModel(final BannerInModelCallBack bannerInModelCallBack){
        NetManagerUtil.getInstance()
                .create(RetroifitServiceApi.class)
                .getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        cd.add(d);
                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {

                        //baseCallBack.onSuccess(bannerBean);
                        if (null == bannerBean) {
                            bannerInModelCallBack.onBannerInModelFail("出现错误");
                        } else if (bannerBean.errorCode != 0) {
                            bannerInModelCallBack.onBannerInModelFail(bannerBean.errorMsg);
                        } else {
                            bannerInModelCallBack.onBannerInModelSuccess(bannerBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                        bannerInModelCallBack.onBannerInModelFail(e.toString());

                    }

                    @Override
                    public void onComplete() {
                        Log.e("==ss==","bannercompleted");
                    }
                });

    }

    //获取首页列表数据的网络请求
    public void getArticleListInModel(int curPage,final ArticleInModelCallBack articleInModelCallBack){
        NetManagerUtil.getInstance()
                .create(RetroifitServiceApi.class)
                .getArticle(curPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArticleListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        cd.add(d);
                    }

                    @Override
                    public void onNext(ArticleListBean value) {
                        if (null == value) {
                            articleInModelCallBack.onArticleInModelFail("出现错误");
                        } else if (value.errorCode != 0) {
                            articleInModelCallBack.onArticleInModelFail(value.errorMsg);
                        } else {
                            articleInModelCallBack.onArticleInModelSuccess(value);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        articleInModelCallBack.onArticleInModelFail("出现错误");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("==ss==","articlecompleted");
                    }
                });
    }
}
