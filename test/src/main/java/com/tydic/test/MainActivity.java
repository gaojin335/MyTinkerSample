package com.tydic.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.tydic.test.tinker.TinkerManager;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private static final boolean DBG = true;
    private static final String TAG = MainActivity.class.getSimpleName();

    private final String PATCH_SUFFIX = ".apk";
    // 补丁包所在目录
    private String mPatchDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 创建补丁包目录
        mPatchDir = getExternalCacheDir().getAbsolutePath() + "/patches";
        File file = new File(mPatchDir);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    // 为第一个按钮添加点击事件
    public void createBug(View view) {
        printLog(null);
    }

    // 为第二个按钮添加点击事件
    public void fixBug(View view) {
        String currentMd5 = "";// 服务器返回的md5值
        TinkerManager.loadPatch(getPatchPath(), currentMd5);
    }

    // 获取补丁文件的路径
    private String getPatchPath() {
        return mPatchDir.concat("/").concat("fix").concat(PATCH_SUFFIX);
    }

    private void printLog(String message) {
        if(message != null) Log.e(TAG, message);
        Toast.makeText(this, "print log success.", Toast.LENGTH_SHORT).show();
    }
}
