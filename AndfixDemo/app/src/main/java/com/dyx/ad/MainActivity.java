package com.dyx.ad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dyx.ad.andfix.AndfixPatchManager;
import com.dyx.ad.andfix.AndfixService;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    /**
     * patch文件后缀名
     */
    private static final String FILE_END = ".apatch";
    @BindView(R.id.btn_add_bug)
    Button btnAddBug;
    @BindView(R.id.btn_fix_bug)
    Button btnFixBug;
    /**
     * patch文件存储目录
     */
    private String mPatchDir;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnbinder = ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        mPatchDir = getExternalCacheDir().getAbsolutePath() + "/apatch/";
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

    @OnClick({R.id.btn_add_bug, R.id.btn_fix_bug})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_add_bug:
                handleAddBug();
                break;
            case R.id.btn_fix_bug:
                //handleFixBug();
                /**
                 * 启动Service
                 */
                startPatchService();
                break;
        }
    }

    private void startPatchService() {
        Intent intent = new Intent(this, AndfixService.class);
        startService(intent);
    }

    private void handleFixBug() {
        try {
            AndfixPatchManager.getInstance().addAndfixPatch(getPatchPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建patch文件名
     *
     * @return
     */
    private String getPatchPath() {
        return mPatchDir.concat("andfix").concat(FILE_END);
    }

    /**
     * 产生bug：IndexOutOfBoundsException
     */
    private void handleAddBug() {
//        /**
//         * 有bug代码
//         */
//        List<String> datas = new ArrayList<>();
//        datas.add("a");
//        Logger.d(datas.get(10));
        /**
         * 修复bug代码
         */
        List<String> datas = new ArrayList<>();
        datas.add("a");
        Logger.d(datas.get(0));
    }
}
