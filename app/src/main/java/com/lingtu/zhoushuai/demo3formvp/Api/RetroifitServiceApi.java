package com.lingtu.zhoushuai.demo3formvp.Api;

import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.bean.ArticleListBean;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.bean.BannerBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetroifitServiceApi {


    /**
     * 获取首页banner数据
     *
     * @return
     */
    @GET("banner/json")
    Observable<BannerBean> getBanner();

    /**
     * wanandroid 首页文章列表
     *
     * @param curPage 当前第几页
     * @return
     */
    @GET("article/list/{curPage}/json")
    Observable<ArticleListBean> getArticle(@Path("curPage") int curPage);
}
