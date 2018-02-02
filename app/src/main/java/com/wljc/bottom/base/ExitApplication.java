package com.wljc.bottom.base;

/**
 * Created by Administrator on 2017/2/18/018.
 */

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * 退出程序的类： 将集合中保存的所有打开的Activity全部关闭
 *
 * @author Rex
 *
 */
public class ExitApplication extends Application {

    private List<Activity> mList = new ArrayList<Activity>();
    private static ExitApplication instance;

    private ExitApplication() {

    }

    public synchronized static ExitApplication getInstance() {
        if (null == instance) {
            instance = new ExitApplication();
        }
        return instance;
    }

    public int sizeActivity() {
        return mList.size();
    }

    public void addActivity(Activity activity) {

        mList.add(activity);

    }

    public void removeActivity(Activity activity) {
        mList.remove(activity);
    }

    public void exit() {
        try {
            for (Activity activity : mList) {
                if (activity != null) {
                    activity.finish();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
