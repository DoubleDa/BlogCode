package com.dyx.td.tinker;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;

import com.dyx.td.model.PatchInfoModel;
import com.dyx.td.net.HttpClientManager;
import com.dyx.td.net.listener.DownloadListener;
import com.dyx.td.net.listener.HttpListener;

import java.io.File;

/**
 * project name：TinkerDemo
 * class describe：
 * create person：dayongxin
 * create time：2017/7/1 下午3:33
 * alter person：dayongxin
 * alter time：2017/7/1 下午3:33
 * alter remark：
 */
public class TinkerService extends Service {
    /**
     * 检测更新patch
     */
    private static final int UPDATE_PATCH = 0x01;
    /**
     * 下载patch
     */
    private static final int DOWNLOAD_PATCH = 0x02;
    /**
     * patch文件结尾
     */
    private static final String FILE_END = ".apk";
    /**
     * 存放文件的文件夹
     */
    private String mPatchFileDir;
    /**
     * 存放文件的文件名
     */
    private String mPatchFile;
    /**
     * PatchInfoModel
     */
    private PatchInfoModel mPatchInfoModel;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_PATCH:
                    checkPatchInfo();
                    break;
                case DOWNLOAD_PATCH:
                    downloadPatch();
                    break;
                default:
                    break;
            }
        }
    };

    private void downloadPatch() {
        mPatchFile = mPatchFileDir.concat(String.valueOf(System.currentTimeMillis())).concat(FILE_END);
        HttpClientManager.getInstance().downloadPatch(mPatchInfoModel.getPatchUrl(), mPatchFile, new DownloadListener() {
            @Override
            public void onSuccess(String successMsg) {
                TinkerManager.loadPatch(mPatchFile, successMsg);
            }

            @Override
            public void onFailed(String failedMsg) {
                stopSelf();
            }

            @Override
            public void onProgress(int progressMsg) {

            }
        });
    }

    private void checkPatchInfo() {
        HttpClientManager.getInstance().checkPatchInfo(new HttpListener() {
            @Override
            public void onSuccess(Object successMsg) {
                mPatchInfoModel = (PatchInfoModel) successMsg;
                mHandler.sendEmptyMessage(DOWNLOAD_PATCH);
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
     * 初始化patch文件存储目录
     */
    private void init() {
        mPatchFileDir = getExternalCacheDir().getAbsolutePath() + "/tpatch/";
        File mFile = new File(mPatchFileDir);
        if (mFile == null || !mFile.exists()) {
            mFile.mkdir();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //检查是否有patch文件
        mHandler.sendEmptyMessage(UPDATE_PATCH);
        return START_NOT_STICKY;
    }
}
