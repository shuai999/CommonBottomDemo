package com.wljc.bottom.base;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;


import java.util.ArrayList;

/**
 * Created by ces
 * on 2017/2/18/018.
 * function  activity中请求网络必须放在initData()中
 */
public abstract class BaseActivity extends FragmentActivity implements
        View.OnClickListener {

    public static final String TAG = "gao_chun";

    //在基类中初始化Dialog
    public Dialog mLoading;


    protected Context mContext;
    private Intent intent;
    protected ExitApplication exitApp;
    public ArrayList<BaseActivity> appList = new ArrayList<BaseActivity>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Resources resource = getResources();
        Configuration c = resource.getConfiguration();
        c.fontScale = 1.0f;
        resource.updateConfiguration(c, resource.getDisplayMetrics());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // 初始化网络请求
        mContext = this;

        // 初始化所有Activity打开的集合
        exitApp = BaseApplication.exitApp;

        exitApp.addActivity(this);
        appList.add(this);

        // 用户ID


        // 初始化布局
        initLayout();

        // 初始化控件
        initView();

        // 初始化数据
        initData();

        // 设置监听器
        setListener();
    }

    public abstract void initLayout();

    public abstract void initData();

    public abstract void initView();

    public abstract void setListener();

    /**
     * 跳转
     * @param clazz
     *            跳转的目标字节码
     */
    protected void startActivity(Class<?> clazz) {
        intent = new Intent(mContext, clazz);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    protected void startforActivity(Class<?> clazz, int mode) {
        intent = new Intent(mContext, clazz);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivityForResult(intent, mode);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }



    /**
     * 隐藏键盘
     */
    public boolean dismissSoftKeyboard() {
        try {
            InputMethodManager inputMethodManage = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            if (this.getCurrentFocus() == null) {
                return inputMethodManage.hideSoftInputFromWindow(this.getWindow().getDecorView().getWindowToken(), 0);
            } else {
                return inputMethodManage.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
