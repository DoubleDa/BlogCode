package com.dyx.td.tinker.custom;

import android.content.Context;

import com.dyx.td.utils.Utils;
import com.tencent.tinker.lib.listener.DefaultPatchListener;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * project name：TinkerDemo
 * class describe：1、校验patch文件是否合法；2、启动Service去安装patch文件；
 * create person：dayongxin
 * create time：2017/7/1 下午5:20
 * alter person：dayongxin
 * alter time：2017/7/1 下午5:20
 * alter remark：
 */
public class CustomPatchListener extends DefaultPatchListener {
    private String currentFileMD5;

    public void setCurrentFileMD5(String currentFileMD5) {
        this.currentFileMD5 = currentFileMD5;
    }

    public CustomPatchListener(Context context) {
        super(context);
    }

    @Override
    protected int patchCheck(String path) {
        //patch文件MD5校验
        if (!Utils.isFileMD5Matched(path, currentFileMD5)) {
            return ShareConstants.ERROR_PATCH_DISABLE;
        }
        return super.patchCheck(path);
    }
}
