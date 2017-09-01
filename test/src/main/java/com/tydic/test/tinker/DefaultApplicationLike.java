package com.tydic.test.tinker;

import android.app.Application;
import android.content.Intent;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by gaobo on 17/7/19.
 */
@DefaultLifeCycle(application = ".MyApplication", flags = ShareConstants.TINKER_ENABLE_ALL)
public class DefaultApplicationLike extends ApplicationLike {
    public DefaultApplicationLike(Application application, int tinkerFlags, boolean
            tinkerLoadVerifyFlag, long applicationStartElapsedTime, long
                                          applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime,
                applicationStartMillisTime, tinkerResultIntent);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化 Tinker
        TinkerManager.installTinker(this);
    }
}
