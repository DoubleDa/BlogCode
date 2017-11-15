package com.dyx.tp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dyx.tp.tinker.TinkerManager;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    /**
     * 文件后缀名
     */
    private static final String FILE_END = ".apk";
    /**
     * patch文件文件夹
     */
    private String mPatchDir;
    private Button mButton;
    private Button btnPatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPatchDir();
        initView();
    }

    private void initView() {
        mButton = (Button) findViewById(R.id.btn_load_patch);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //加载更新Patch包
                TinkerManager.loadPatch(getPatchFilePath());
            }
        });
        btnPatch = (Button) findViewById(R.id.btn_new);
        btnPatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, getString(R.string.str_patch_info), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initPatchDir() {
        mPatchDir = getExternalCacheDir().getAbsolutePath() + "/tpatch/";
        File mFile = new File(mPatchDir);
        if (mFile == null || !mFile.exists()) {
            mFile.mkdir();
        }
    }

    /**
     * @return
     * @function 获取patch文件路径
     */
    private String getPatchFilePath() {
        return mPatchDir.concat("tinker").concat(FILE_END);
    }
}
