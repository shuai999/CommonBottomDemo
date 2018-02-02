package com.wljc.bottom.fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.wljc.bottom.R;
import com.wljc.bottom.base.BaseFragment;
import com.wljc.bottom.fragment.lazy.LazyLoadFragment;
import com.wljc.bottom.util.ToastUtils;
import com.wljc.bottom.util.UiUtils;


/**
 * @author ces
 * @date 2017/2/26/026
 */
public class ThreeFragment extends LazyLoadFragment implements View.OnClickListener {


    @Override
    public int setContentView() {
        return R.layout.fragment_three;
    }

    @Override
    protected void lazyLoad() {
        String message = "ThreeFragment" + (isInit ? "已经初始并已经显示给用户可以加载数据" : "没有初始化不能加载数据")+">>>>>>>>>>>>>>>>>>>";
        showToast(message);
        Log.d(TAG, message);
    }

    @Override
    protected void stopLoad() {
        Log.d(TAG, "Fragment1" + "已经对用户不可见，可以停止加载数据");
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {

    }

}
