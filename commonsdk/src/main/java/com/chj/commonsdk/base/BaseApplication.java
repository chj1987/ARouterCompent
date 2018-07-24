package com.chj.commonsdk.base;

import android.app.Application;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.multidex.MultiDex;

import com.chj.commonsdk.BuildConfig;
import com.chj.commonsdk.utils.LogUtil;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class BaseApplication extends Application {
    public static final String TAG = BaseApplication.class.getSimpleName();
    private static boolean IS_DEBUG = BuildConfig.DEBUG;
    private static BaseApplication mApp;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        mApp = this;
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, @Nullable String tag) {
                return BuildConfig.DEBUG;
            }
        });
        LogUtil.d(TAG, "onCreate");
    }
}
