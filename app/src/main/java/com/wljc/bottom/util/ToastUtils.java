package com.wljc.bottom.util;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wljc.bottom.base.BaseApplication;


/**
 * toast工具类
 * 修改 避免Toast连续显示 by mxy on 2017/3/4
 */

public class ToastUtils {

    public static final int OPTION_SUCCESS = 0;
    public static final int OPTION_FAIL = 1;
    public static void toastS(String msg) {
        Toast.makeText(BaseApplication.getContext(), msg, Toast.LENGTH_SHORT).show();
    }
//    public static void toastD(Context context, String msg) {
//        doLoginOut();
//        NoLoginDialog dialog = new NoLoginDialog(context,msg);
//        dialog.show();
//    }

    public static void toastS(String message, Context context) {
//        if (myToast == null) {
//            myToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
//        } else {
//            myToast.setText(message);
//            myToast.setDuration(Toast.LENGTH_SHORT);
//        }
//        myToast.show();
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
    private static Toast myToast;
//    /**
//     * 显示自定义的Toast
//     * showToast
//     *
//     * @param context 上下文对象
//     * @Title: showToast
//     * @Description: TODO
//     */
//    public static void showMyToast(Context context, int state, String msg) {
//        View toast_view = ((Activity) context).getLayoutInflater().inflate(R.layout.layout_toast, null);
//        ImageView iv_load = (ImageView) toast_view.findViewById(R.id.iv_dialog);
//        TextView tv_load = (TextView) toast_view.findViewById(R.id.tv_tips);
//        tv_load.setText(msg);
//        if(state == OPTION_SUCCESS){//成功
//            iv_load.setImageResource(R.mipmap.ok);
//        }else{//失败
//            iv_load.setImageResource(R.mipmap.fail);
//        }
//        //避免Toast连续显示
//        if (myToast == null) {
//            myToast = new Toast(context);
//        } else {
//            //设置toast显示时间
//            myToast.setDuration(Toast.LENGTH_SHORT);
//        }
//        //设置toast显示位置
//        myToast.setGravity(Gravity.CENTER, 0, 0);
//        //设置toast显示的view
//        myToast.setView(toast_view);
//        myToast.show();
//    }
//
//    private static void doLoginOut(){
//        PrefUtils.RemoveString(BaseApplication.getContext(), "tel");
//        PrefUtils.RemoveString(BaseApplication.getContext(), "uid");
//        PrefUtils.RemoveString(BaseApplication.getContext(), "token");
//        PrefUtils.putBoolean(BaseApplication.getContext(), "isLogin", false);
//    }
}
