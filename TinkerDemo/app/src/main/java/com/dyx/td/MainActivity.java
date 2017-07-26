package com.dyx.td;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.dyx.td.tinker.TinkerManager;
import com.dyx.td.tinker.TinkerService;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    /**
     * 文件后缀名
     */
    private static final String FILE_END = ".apk";
    @BindView(R.id.btn_load_patch)
    Button btnLoadPatch;
    /**
     * patch文件文件夹
     */
    private String mPatchDir;

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnbinder = ButterKnife.bind(this);
        initPatchDir();
    }

    private void initPatchDir() {
        mPatchDir = getExternalCacheDir().getAbsolutePath() + "/tpatch/";
        File mFile = new File(mPatchDir);
        if (mFile == null || !mFile.exists()) {
            mFile.mkdir();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    @OnClick(R.id.btn_load_patch)
    public void onViewClicked() {
        //加载patch文件
        TinkerManager.loadPatch(getPatchFilePath(), "MD5");
        //启动检测Tinker Service
        startTinkerService();
    }

    private void startTinkerService() {
        Intent intent = new Intent(this, TinkerService.class);
        startService(intent);
    }

    /**
     * @return
     * @function 获取patch文件路径
     */
    private String getPatchFilePath() {
        return mPatchDir.concat("tinker").concat(FILE_END);
    }
}
