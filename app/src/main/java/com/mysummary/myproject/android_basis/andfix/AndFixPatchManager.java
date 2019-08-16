package com.mysummary.myproject.android_basis.andfix;

import android.content.Context;

import com.alipay.euler.andfix.patch.PatchManager;
import com.mysummary.myproject.utils.CommonUtil;

import java.io.IOException;

/**
 * Created by xingzhi on 2018/9/29.
 * <p>
 * 管理AndFix 的api
 */

public class AndFixPatchManager {


    private static AndFixPatchManager mInstance = null;
    private static PatchManager mPatchManager = null;

    public static AndFixPatchManager getInstance() {
        if (mInstance == null) {
            synchronized (AndFixPatchManager.class) {
                if (mInstance == null) {
                    mInstance = new AndFixPatchManager();
                }
            }
        }
        return mInstance;
    }


    //初始化AndFix方法
    public void initManager(Context context) {
        mPatchManager = new PatchManager(context);
        mPatchManager.init(CommonUtil.getLocalVersionName(context));
        mPatchManager.loadPatch();//
    }

    //加载patch文件
    public void addPatch(String path) {
        try {
            if (mPatchManager != null) {
                mPatchManager.addPatch(path);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
