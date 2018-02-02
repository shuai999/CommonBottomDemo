package com.wljc.bottom.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * Created by Administrator on 2017/2/18/018.
 */
@SuppressLint("NewApi")
public abstract class BaseFragment extends Fragment {

    protected Activity mActivity;
    public Context mContext;
    protected View mView;
    private Intent intent;

    /** Fragment当前状态是否可见 */
    protected boolean isVisible;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 所依赖的activity
        mActivity = getActivity();
        mContext = BaseApplication.getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 初始化布局
        mView = initLayout(inflater);

        // 初始化控件
        initView();
        // 设置监听器
        setListener();
        // 初始化数据
        initData();
        // 初始化U_id

        return mView;
    }




    public abstract View initLayout(LayoutInflater inflater);

    public abstract void initView();

    public abstract void setListener();

    public abstract void initData();
}
