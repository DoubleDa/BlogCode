package com.dyx.ad.andfix;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.dyx.ad.model.PatchInfoModel;
import com.dyx.ad.net.HttpClientManager;
import com.dyx.ad.net.listener.DownloadListener;
import com.dyx.ad.net.listener.HttpListener;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.IOException;

/**
 * project name：AndfixDemo
 * class describe：
 * create person：dayongxin
 * create time：2017/6/30 上午10:16
 * alter person：dayongxin
 * alter time：2017/6/30 上午10:16
 * alter remark：1、检查patch文件；2、下载patch文件；3、加载patch文件；
 */
public class AndfixService extends Service {
    /**
     * 更新patch
     */
    private static final int UPDATE_PATCH = 0x01;
    /**
     * 下载patch
     */
    private static final int DOWNLOAD_PATCH = 0x02;
    /**
     * 添加patch
     */
    private static final int ADD_PATCH = 0x03;
    /**
     * patch文件结尾
     */
    private static final String FILE_END = ".apatch";
    /**
     * 存放文件的文件夹
     */
    private String mPatchFileDir;
    /**
     * 存放文件的文件名
     */
    private String mPatchFile;
    /**
     * 消息分发
     */
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_PATCH:
                    //检查patch文件更新
                    checkPatchFileUpdate();
                    break;
                case DOWNLOAD_PATCH:
                    //下载更新的patch文件
                    downloadPatchFile();
                    break;
                case ADD_PATCH:
                    //添加patch文件成功
                    break;
                default:
                    break;
            }
        }
    };

    private PatchInfoModel mPatchInfoModel;

    private void downloadPatchFile() {
        //初始化patch文件下载路径
        mPatchFile = mPatchFileDir.concat(String.valueOf(System.currentTimeMillis())).concat(FILE_END);
        //进行下载文件网络请求
        HttpClientManager.getInstance().downloadPatchFile(mPatchInfoModel.getPatchUrl(), mPatchFile, new DownloadListener() {
            @Override
            public void onSuccess(Object successMsg) {
                //将下载到本地的patch文件添加到andfix中
                try {
                    AndfixPatchManager.getInstance().addAndfixPatch(mPatchFile);
                    mHandler.sendEmptyMessage(ADD_PATCH);
                } catch (IOException e) {
                    e.printStackTrace();
                    stopSelf();
                }
            }

            @Override
            public void onFailed(Object failedMsg) {
                stopSelf();
            }

            @Override
            public void onProgress(int progressMsg) {
                Logger.d(progressMsg);
            }
        });
    }

    private void checkPatchFileUpdate() {
        HttpClientManager.getInstance().checkPatchInfo(new HttpListener() {
            @Override
            public void onSuccess(Object successMsg) {
                mPatchInfoModel = (PatchInfoModel) successMsg;
                if (mPatchInfoModel != null) {
                    if (!TextUtils.isEmpty(mPatchInfoModel.getPatchUrl())) {
                        mHandler.sendEmptyMessage(DOWNLOAD_PATCH);
                    } else {
                        stopSelf();
                    }
                }
            }

            @Override
            public void onFailed(Object failedMsg) {
                stopSelf();
            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    /**
     * 1、文件夹的创建；
     * 2、文件夹的初始化；
     */
    private void init() {
        //指定路径
        mPatchFileDir = getExternalCacheDir().getAbsolutePath() + "/apatch/";
        //创建文件夹
        File mFile = new File(mPatchFileDir);
        try {
            if (mFile == null || !mFile.exists()) {
                mFile.mkdir();
            }
        } catch (Exception e) {
            e.printStackTrace();
            stopSelf();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mHandler.sendEmptyMessage(UPDATE_PATCH);
        return START_NOT_STICKY;
    }
}
