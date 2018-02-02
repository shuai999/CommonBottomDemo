package com.wljc.bottom.util;

/**
 * Created by Administrator on 2017/2/18/018.
 */

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;


import com.wljc.bottom.base.BaseApplication;

import java.lang.reflect.Field;

/**
 * 提供ui操作的帮助类
 *
 *
 */
public class UiUtils {
    // 获取context对象
    public static Context getContext() {
        return BaseApplication.getContext();
    }

    // 获取主线程的handler
    public static Handler getMainThreadHandler() {
        return BaseApplication.getHandler();
    }

    // 获取主线程的线程id
    public static int getMainThreadId() {
        return BaseApplication.getMainThreadId();
    }

    // 获取字符串
    public static String getString(int id) {
        return getContext().getResources().getString(id);
    }

    // 获取字符串数组
    public static String[] getStringArray(int id) {
        return getContext().getResources().getStringArray(id);
    }

    // 获取drawable
    public static Drawable getDrawable(int id) {
        return getContext().getResources().getDrawable(id);
    }

    // 获取color
    public static int getColor(int id) {
        return getContext().getResources().getColor(id);
    }

    // 获取color的状态选择器
    public static ColorStateList getColorStateList(int id) {
        return getContext().getResources().getColorStateList(id);
    }

    // dimen下对应的像素值
    public static int getDimen(int id) {
        return getContext().getResources().getDimensionPixelSize(id);
    }

    // dp-->px
    public static int dip2px(int dip) {
        float density = getContext().getResources().getDisplayMetrics().density;// 320dpi/160=2
        return (int) (dip * density + 0.5);// 加上0.5 四舍五入
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay()
                .getMetrics(localDisplayMetrics);
        return localDisplayMetrics.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay()
                .getMetrics(localDisplayMetrics);
        return localDisplayMetrics.heightPixels - getStatusBarHeight(context);
    }

    public static int getStatusBarHeight(Context context) {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return statusBarHeight;
    }

    // 判断是否在主线程中运行
    public static boolean isRunOnUiThread() {
        int currentThreadId = android.os.Process.myTid();// 获取当前线程所在的id
        return currentThreadId == getMainThreadId();
    }

    // 让r一定在主线程当中执行
    public static void runOnUiThread(Runnable r) {
        if (isRunOnUiThread()) {
            r.run();// r.start--启动新的线程
        } else {
            getMainThreadHandler().post(r);// 把r放到主线程的消息队列执行
        }
    }

    // 加载布局文件
    public static View inflateView(int id) {

        return View.inflate(getContext(), id, null);
    }

    private static Toast toast;

    // 弹吐司
    public static void showToast(String str, Context mContext) {
        // Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
        if (toast == null) {
            toast = Toast.makeText(mContext, str, Toast.LENGTH_SHORT);
        } else {
            toast.setText(str);
        }
        toast.show();
    }

    // 弹吐司
    public static void showToast(String str) {
        showToast(str, getContext());
        // Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
    }

    // 弹长吐司
    public static void showLongToast(String str, Context mContext) {
        // Toast.makeText(mContext, str, Toast.LENGTH_LONG).show();
        if (toast == null) {
            toast = Toast.makeText(mContext, str, Toast.LENGTH_LONG);
        } else {
            toast.setText(str);
        }
        toast.show();
    }

}
