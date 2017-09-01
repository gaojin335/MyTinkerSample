package com.tydic.test.tinker;

import android.content.Context;

import com.tencent.tinker.lib.listener.DefaultPatchListener;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by gaobo on 17/8/11.
 * 1.校验patch文件是否合法 2.启动service去安装patch文件
 */
public class CustomPatchListener extends DefaultPatchListener{
    private String currentMd5;

    public void setCurrentMd5(String currentMd5) {
        this.currentMd5 = currentMd5;
    }

    public CustomPatchListener(Context context) {
        super(context);
    }

    @Override
    protected int patchCheck(String path) {
        // patch文件md5校验
        if (!Utils.isFileMd5Checked(path, currentMd5)) {
            return ShareConstants.ERROR_PATCH_DISABLE;
        }
        return super.patchCheck(path);
    }
}
