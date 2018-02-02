package com.wljc.bottom.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;


/**
 * 自定义的Application 1、运行的过程中只有一个实例 2、一个应用程序最先执行的方法 运行在主线程中
 * 注意：在AndroidManifest文件中进行注册
 *
 * @author ces
 *
 */
public class BaseApplication extends Application {

    private static Context context;
    private static Handler handler;
    private static int mainThreadId;
    public static ExitApplication exitApp;
//    public static BaseApplication instance;
//
//    public static BaseApplication getInstance() {
//        return instance;
//    }
    @Override
    public void onCreate() {
        super.onCreate();
//        instance = this;
        // 初始化context对象，context对象使用的非常多
        context = getApplicationContext();
        // 获取主线程的handler 相当于获取主线程的消息队列
        handler = new Handler();
        // 获取主线程的id 哪一个方法调用了myTid myTid就返回那个方法所在线程的id
        mainThreadId = android.os.Process.myTid();
        exitApp = ExitApplication.getInstance();
    }

//    @Override
//    public void onLowMemory() {
//        Glide.with(this).onLowMemory();
//        super.onLowMemory();
//    }

    public static Context getContext() {
        return context;
    }

    public static Handler getHandler() {
        return handler;
    }

    public static int getMainThreadId() {
        return mainThreadId;
    }

//    {
//        PlatformConfig.setWeixin("wxafd26d3d88586957", "5147196926e50cf9740fb9d0614c9682");
//        PlatformConfig.setQQZone("1105945781", "rE8L1ExD0mJjMZmV");
//        PlatformConfig.setSinaWeibo("2399338227", "13e658c04b38cffaaeea83932abb341a", "https://sns.whalecloud.com/sina2/callback");
//    }
}