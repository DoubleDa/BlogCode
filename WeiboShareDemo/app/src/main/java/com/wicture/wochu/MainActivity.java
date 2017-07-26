package com.wicture.wochu;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.api.BaseMediaObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.sina.weibo.sdk.share.WbShareHandler;
import com.sina.weibo.sdk.utils.Utility;

public class MainActivity extends AppCompatActivity implements WbShareCallback {
    private Button mButton;
    private WbShareHandler mWbShareHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWbSdk();
        mButton = (Button) findViewById(R.id.btn_weibo);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToWeibo();
            }
        });
    }

    private void sendToWeibo() {
        WeiboMultiMessage mWeiboMultiMessage = new WeiboMultiMessage();
        mWeiboMultiMessage.mediaObject = getMediaObject();
        mWbShareHandler.shareMessage(mWeiboMultiMessage, true);
    }

    private BaseMediaObject getMediaObject() {
        WebpageObject mWebpageObject = new WebpageObject();
        mWebpageObject.identify = Utility.generateGUID();
        mWebpageObject.title = "测试title";
        mWebpageObject.description = "测试描述";
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        // 设置 Bitmap 类型的图片到视频对象里         设置缩略图。 注意：最终压缩过的缩略图大小不得超过 32kb。
        mWebpageObject.setThumbImage(bitmap);
        mWebpageObject.actionUrl = "http://news.sina.com.cn/c/2013-10-22/021928494669.shtml";
        mWebpageObject.defaultText = "Webpage 默认文案";
        return mWebpageObject;
    }

    private void initWbSdk() {
        WbSdk.install(this, new AuthInfo(this, Constants.APP_KEY, Constants.REDIRECT_URL, Constants.SCOPE));
        mWbShareHandler = new WbShareHandler(this);
        mWbShareHandler.registerApp();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        mWbShareHandler.doResultIntent(intent, this);
    }

    @Override
    public void onWbShareSuccess() {

    }

    @Override
    public void onWbShareCancel() {

    }

    @Override
    public void onWbShareFail() {

    }
}
