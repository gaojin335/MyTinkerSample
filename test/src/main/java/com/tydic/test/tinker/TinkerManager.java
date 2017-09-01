package com.tydic.test.tinker;

import android.content.Context;

import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.ApplicationLike;

/**
 * Created by gaobo on 17/7/19.
 */
// 对 Tinker 进行一层封装
public class TinkerManager {
    private static ApplicationLike mApplicationLike;

    private static CustomPatchListener mCustomPatchListener;

    // 安装 Tinker
    public static void installTinker(ApplicationLike applicationLike) {
        mApplicationLike = applicationLike;
        if (!Tinker.isTinkerInstalled()) {
            mCustomPatchListener = new CustomPatchListener(getApplicationContext());
            TinkerInstaller.install(mApplicationLike);
        }
    }

    // 加载补丁包
    public static void loadPatch(String path, String currentMd5) {
        if (Tinker.isTinkerInstalled()) {
            mCustomPatchListener.setCurrentMd5(currentMd5);
            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), path);
        }
    }

    // 获取上下文
    private static Context getApplicationContext() {
        if (mApplicationLike != null)
            return mApplicationLike.getApplication().getApplicationContext();
        return null;
    }
}
