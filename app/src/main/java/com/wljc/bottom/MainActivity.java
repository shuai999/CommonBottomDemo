package com.wljc.bottom;

import android.os.Process;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wljc.bottom.base.BaseActivity;
import com.wljc.bottom.fragment.FragmentManagerHelper;
import com.wljc.bottom.fragment.OneFragment;
import com.wljc.bottom.fragment.ThreeFragment;
import com.wljc.bottom.fragment.TwoFragment;
import com.wljc.bottom.util.ToastUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    @Bind(R.id.layout_main_content)
    FrameLayout layoutMainContent;
    @Bind(R.id.img_main_tab1)
    ImageView imgMainTab1;
    @Bind(R.id.tv_main_tab1)
    TextView tvMainTab1;
    @Bind(R.id.layout_main_tab1)
    RelativeLayout layoutMainTab1;
    @Bind(R.id.img_main_tab2)
    ImageView imgMainTab2;
    @Bind(R.id.tv_main_tab2)
    TextView tvMainTab2;
    @Bind(R.id.layout_main_tab2)
    RelativeLayout layoutMainTab2;
    @Bind(R.id.img_main_tab3)
    ImageView imgMainTab3;
    @Bind(R.id.tv_main_tab3)
    TextView tvMainTab3;
    @Bind(R.id.layout_main_tab3)
    RelativeLayout layoutMainTab3;


    // fragment管理类
    private FragmentManager mFragmentManager;
    private OneFragment fragment1;
    private TwoFragment fragment2;
    private ThreeFragment fragment3;


    // 上一次按下的tabID
    private int tabIndex = 1;
    /**
     * 记录按下的TAB msgid
     */
    private static final int TAB1 = 0;
    public static final int TAB2 = 1;
    public static final int TAB3 = 2;
    // 记录按下返回键的次数
    private int exitcount = 0;
    private Fragment mContent;
    private FragmentManagerHelper mFragmentHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        mFragmentHelper = new FragmentManagerHelper(getSupportFragmentManager(), R.id.layout_main_content);
        fragment1 = new OneFragment();
        mFragmentHelper.add(fragment1);
        tvMainTab1.setTextColor(getResources().getColor(R.color.tittl));
        imgMainTab1.setImageResource(R.mipmap.home_normal);
        tvMainTab2.setTextColor(getResources().getColor(R.color.text_color_normal1));
        imgMainTab2.setImageResource(R.mipmap.community_disabled);
        tvMainTab3.setTextColor(getResources().getColor(R.color.text_color_normal1));
        imgMainTab3.setImageResource(R.mipmap.ar_disable);
    }

    @Override
    public void initLayout() {
    }

    @Override
    public void initData() {
    }

    @Override
    public void initView() {

    }


    @Override
    public void setListener() {
    }


    @OnClick({R.id.layout_main_tab1, R.id.layout_main_tab2, R.id.layout_main_tab3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.layout_main_tab1:
                tvMainTab1.setTextColor(getResources().getColor(R.color.tittl));
                imgMainTab1.setImageResource(R.mipmap.home_normal);
                tvMainTab2.setTextColor(getResources().getColor(R.color.text_color_normal1));
                imgMainTab2.setImageResource(R.mipmap.community_disabled);
                tvMainTab3.setTextColor(getResources().getColor(R.color.text_color_normal1));
                imgMainTab3.setImageResource(R.mipmap.ar_disable);
                if (fragment1 == null) {
                    fragment1 = new OneFragment();
                }
                mFragmentHelper.switchFragmnet(fragment1);
                break;
            case R.id.layout_main_tab2:
                tvMainTab1.setTextColor(getResources().getColor(R.color.text_color_normal1));
                imgMainTab1.setImageResource(R.mipmap.home_disabled);
                tvMainTab2.setTextColor(getResources().getColor(R.color.tittl));
                imgMainTab2.setImageResource(R.mipmap.community_normal);
                tvMainTab3.setTextColor(getResources().getColor(R.color.text_color_normal1));
                imgMainTab3.setImageResource(R.mipmap.ar_disable);
                if (fragment2 == null) {
                    fragment2 = new TwoFragment();
                }
                mFragmentHelper.switchFragmnet(fragment2);
                break;
            case R.id.layout_main_tab3:
                tvMainTab1.setTextColor(getResources().getColor(R.color.text_color_normal1));
                imgMainTab1.setImageResource(R.mipmap.home_disabled);
                tvMainTab2.setTextColor(getResources().getColor(R.color.text_color_normal1));
                imgMainTab2.setImageResource(R.mipmap.community_disabled);
                tvMainTab3.setTextColor(getResources().getColor(R.color.tittl));
                imgMainTab3.setImageResource(R.mipmap.ar_normal);
                if (fragment3 == null) {
                    fragment3 = new ThreeFragment();
                }
                mFragmentHelper.switchFragmnet(fragment3);
                break;
        }
    }


    @Override
    public void onClick(View view) {

    }

    /**
     * 应用退出
     */
    @Override
    public void onBackPressed() {
        if (exitcount == 0) {
            exitcount++;
            ToastUtils.toastS("再按一次退出应用", MainActivity.this);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                    }
                    exitcount = 0;
                }
            }).start();
        } else {
            Process.killProcess(Process.myPid());
        }

    }


}
