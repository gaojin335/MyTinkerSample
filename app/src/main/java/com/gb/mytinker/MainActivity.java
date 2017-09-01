package com.gb.mytinker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.gb.mytinker.tinker.TinkerManager;
import com.gb.mytinker.util.Utils;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    public static final String PATCH_SUFFIX = ".apk";

    private String mPatchDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 创建补丁存放的目录
        mPatchDir = getExternalCacheDir().getAbsolutePath() + "/patches/";
        File file = new File(mPatchDir);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public void createBug(View view) {
        Utils.printLog(null);
        Toast.makeText(this, "Print log success", Toast.LENGTH_SHORT).show();
    }

    public void fixBug(View view) {
        TinkerManager.loadPatch(getPatchName());
    }

    private String getPatchName() {
        return mPatchDir.concat("fix").concat(PATCH_SUFFIX);
    }
}
