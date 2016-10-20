package com.jaydenxiao.androidfire.base;

import android.content.Intent;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jaydenxiao.androidfire.R;
import com.jaydenxiao.common.base.BaseFragment;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by wangfengkai on 2016/10/18.
 */
public class WebViewFragment extends BaseFragment {

    @Bind(R.id.tv_title_center)
    TextView tv_title_center;
    @Bind(R.id.rl_title_left)
    RelativeLayout rl_title_left;
    @Bind(R.id.webview)
    WebView webview;

    public static WebViewFragment newInstance() {
        return new WebViewFragment();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_webview;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        tv_title_center.setText("Demo实例");
        WebSettings webSettings = webview.getSettings();
        webview.requestFocusFromTouch();
        webSettings.setAllowContentAccess(true);
        webSettings.setAppCacheEnabled(false);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webview.setWebViewClient(new myWebViewClient());
        webview.setWebChromeClient(new WebChromeClient());
        webSettings.setJavaScriptEnabled(true);
        webview.loadUrl("http://gank.io/");
    }

    private class myWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }

    private class WebChromeClient extends android.webkit.WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            if (newProgress == 100){

            }else{

            }
        }
    }

    @OnClick(R.id.rl_title_left)
    public void goback(){
        getActivity().finish();
    }


}
