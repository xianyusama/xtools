package com.xkq.xiao.xtools;

import android.app.Application;

import com.xkq.xiao.xutils.common.klog.KLog;

/**
 * Created by xiao on 2017/4/5.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        KLog.init(true,"UTIL");
    }
}
