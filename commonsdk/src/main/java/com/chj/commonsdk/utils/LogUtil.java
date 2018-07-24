package com.chj.commonsdk.utils;

import com.orhanobut.logger.Logger;

public class LogUtil {
    public static void v(String tag, String msg) {
        Logger.t(tag).v(msg);

    }

    public static void v(String tag, String msg, Throwable throwable) {

        Logger.t(tag).v(msg, throwable);

    }

    public static void d(String tag, String msg) {

        Logger.t(tag).d(msg);

    }

    public static void d(String tag, String msg, Throwable throwable) {


        Logger.t(tag).d(msg, throwable);


    }

    public static void i(String tag, String msg) {

        Logger.t(tag).i(msg);

    }

    public static void i(String tag, String msg, Throwable throwable) {

        Logger.t(tag).i(msg, throwable);

    }

    public static void w(String tag, String msg) {

        Logger.t(tag).w(msg);

    }

    public static void w(String tag, String msg, Throwable throwable) {

        Logger.t(tag).w(msg, throwable);

    }

    public static void e(String tag, String msg) {

        Logger.t(tag).e(msg);

    }

    public static void e(String tag, String msg, Throwable throwable) {

        Logger.t(tag).e(msg, throwable);

    }

    public static void json(String tag, String json) {
        Logger.t(tag).json(json);
    }
}
