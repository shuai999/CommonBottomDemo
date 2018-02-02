package com.wljc.bottom.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioGroup;

import com.wljc.bottom.R;
import com.wljc.bottom.base.BaseFragment;
import com.wljc.bottom.fragment.lazy.Fragment1;
import com.wljc.bottom.fragment.lazy.Fragment2;
import com.wljc.bottom.fragment.lazy.Fragment3;
import com.wljc.bottom.fragment.lazy.LazyLoadFragment;
import com.wljc.bottom.util.ToastUtils;
import com.wljc.bottom.util.UiUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * @author ces
 * @date 2017/2/26/026
 */
public class TwoFragment extends LazyLoadFragment implements View.OnClickListener {


    private RadioGroup rg;
    private ViewPager vp;

    @Override
    public int setContentView() {
        return R.layout.fragment_two;
    }

    @Override
    protected void lazyLoad() {
        String message = "TwoFragment" + (isInit ? "已经初始并已经显示给用户可以加载数据" : "没有初始化不能加载数据")+">>>>>>>>>>>>>>>>>>>";
        showToast(message);
        Log.d(TAG, message);
    }

    @Override
    protected void stopLoad() {
        Log.d(TAG, "Fragment1" + "已经对用户不可见，可以停止加载数据");
    }

    @Override
    public void initView() {
        rg = (RadioGroup) getContentView().findViewById(R.id.rg);
        vp = (ViewPager) getContentView().findViewById(R.id.vp);
    }

    @Override
    public void initData() {
        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        vp.setOffscreenPageLimit(0);
        vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                vp.setCurrentItem(radioGroup.indexOfChild(radioGroup.findViewById(i)));
            }
        });
    }

    @Override
    public void setListener() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }

}
