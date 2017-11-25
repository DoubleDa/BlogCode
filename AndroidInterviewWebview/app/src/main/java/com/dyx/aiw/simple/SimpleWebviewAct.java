package com.dyx.aiw.simple;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.dyx.aiw.R;

/**
 * Author：dayongxin
 * Function：简单使用WebView&在多进程模式下使用WebView
 */
public class SimpleWebviewAct extends Activity {
    private static final String TAG = "***SimpleWebviewAct***";
    private WebView mWebView;
    public static final String BUNDLE_KEY = "bundle_key";
    private String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_webview);
        url = getIntent().getStringExtra(BUNDLE_KEY);
        initView();
    }

    private void initView() {
        mWebView = findViewById(R.id.wv_simple);
        //1、WebView设置
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        //注意Activity页面的硬件加速跟Webview页面的硬件加速区别开来
        //开启硬件加速
        mWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        if (mWebView.isHardwareAccelerated()) {
            Log.i(TAG, "硬件加速开启！");
        } else {
            Log.i(TAG, "硬件加速关闭！");
        }
        //2、设置WebViewClient
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }
        });
        //3、设置WebChromeClient
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }

            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
            }
        });
        //4、加载url
        mWebView.loadUrl(url);
    }
}
