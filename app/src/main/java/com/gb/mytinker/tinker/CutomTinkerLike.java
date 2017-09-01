package com.gb.mytinker.tinker;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by gaobo on 17/7/13.
 */
@DefaultLifeCycle(application = "com.gb.mytinker.tinker.MyTinkerApplication",
        flags = ShareConstants.TINKER_ENABLE_ALL)
public class CutomTinkerLike extends ApplicationLike {

    public CutomTinkerLike(Application application, int tinkerFlags, boolean
            tinkerLoadVerifyFlag, long applicationStartElapsedTime, long
                                   applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime,
                applicationStartMillisTime, tinkerResultIntent);
    }

    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        // 使应用支持分包
        MultiDex.install(base);
        TinkerManager.installTinker(this);
    }
}
