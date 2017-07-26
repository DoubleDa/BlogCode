package com.dyx.td.tinker.custom;

import com.orhanobut.logger.Logger;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.lib.service.PatchResult;
import com.tencent.tinker.lib.util.TinkerServiceInternals;

import java.io.File;

/**
 * project name：TinkerDemo
 * class describe：进行patch包安装成功后的后续操作
 * create person：dayongxin
 * create time：2017/7/1 下午5:21
 * alter person：dayongxin
 * alter time：2017/7/1 下午5:21
 * alter remark：
 */
public class CustomResultService extends DefaultTinkerResultService {
    /**
     * 返回patch文件安装结果
     *
     * @param result
     */
    @Override
    public void onPatchResult(PatchResult result) {
        if (result == null) {
            Logger.d("DefaultTinkerResultService received null result!!!!");
            return;
        }
        Logger.d("DefaultTinkerResultService received a result:" + result.toString());

        TinkerServiceInternals.killTinkerPatchServiceProcess(getApplicationContext());

        if (result.isSuccess) {
            deleteRawPatchFile(new File(result.rawPatchFilePath));
        }
    }
}
