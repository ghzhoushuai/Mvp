package com.lingtu.zhoushuai.demo3formvp.wanAndroid.presenter;

import android.util.Log;



import com.lingtu.zhoushuai.demo3formvp.wanAndroid.contract.WanAndroidContract;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.BannerModel;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.bean.ArticleListBean;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.bean.BannerBean;

import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.callback.ArticleInModelCallBack;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.callback.BannerInModelCallBack;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.view.WanAndroidDemoActivity;

public class BannerPresenter implements WanAndroidContract.Presenter{

    /**
     * 针对有可能需要context的情况，在BaseView中写了getContext方法，在Presenter中可以通过view的对象获取context
     */
    //持有model对象
    private BannerModel bannerModel=new BannerModel();
    //持有view对象
    private WanAndroidDemoActivity mView;

    public BannerPresenter(WanAndroidDemoActivity mView){
        this.mView=mView;
    }

    public void detachView() {
        Log.e("==ss==","执行了取消注册的操作");
        bannerModel.doDispose();
        mView=null;
    }



    @Override
    public void getBanner() {

        mView.showLoading();

        bannerModel.getBannerInModel(new BannerInModelCallBack() {
            @Override
            public void onBannerInModelSuccess(BannerBean bannerBean) {
                mView.onBannerSuccess(bannerBean);
                mView.hideLoading();
            }

            @Override
            public void onBannerInModelFail(String errorMessage) {
                mView.onBannerFail(errorMessage);
                mView.hideLoading();
            }
        });
    }

    @Override
    public void getArticle(int curPage) {
        mView.showLoading();

        bannerModel.getArticleListInModel(curPage, new ArticleInModelCallBack() {
            @Override
            public void onArticleInModelSuccess(ArticleListBean articleListBean) {
                mView.onArticleSuccess(articleListBean);
                mView.hideLoading();
            }

            @Override
            public void onArticleInModelFail(String errorMessage) {
                mView.onArticleFail(errorMessage);
                mView.hideLoading();
            }
        });
    }

}
