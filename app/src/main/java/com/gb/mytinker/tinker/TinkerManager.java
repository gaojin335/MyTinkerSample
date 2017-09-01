package com.gb.mytinker.tinker;

import android.content.Context;

import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.ApplicationLike;

/**
 * Created by gaobo on 17/7/13.
 * 对Tinker的API做一层封装
 */
public class TinkerManager {
    // Tinker 是否安装
    private static boolean isInstalled;

    private static ApplicationLike mAppLike;

    /**
     * 初始化 Tinker
     * @param applicationLike
     */
    public static void installTinker(ApplicationLike applicationLike) {
        mAppLike = applicationLike;
        if (isInstalled) {
            return;
        }
        // 初始化 Tinker
        TinkerInstaller.install(applicationLike);
        isInstalled = true;
    }

    /**
     * 加载补丁包
     * @param path
     */
    public static void loadPatch(String path) {
        if (Tinker.isTinkerInstalled()) {
            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), path);
        }
    }

    private static Context getApplicationContext() {
        if (mAppLike != null) {
            return mAppLike.getApplication().getApplicationContext();
        }
        return null;
    }

}
