package com.jaydenxiao.androidfire.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.jaydenxiao.androidfire.R;
import com.jaydenxiao.androidfire.config.Constant;
import com.jaydenxiao.androidfire.factory.FragmentFactory;
import com.jaydenxiao.androidfire.base.SubActivity;
import com.jaydenxiao.androidfire.ui.main.activity.MainActivity;

import org.parceler.Parcels;

/**
 * Created by wangfengkai on 2016/10/14.
 */
public class PageSwitcherManager {

    public final static String INTENT_EXTRA_FRAGMENT_TYPE = "fragment_type";
    public final static String INTENT_EXTRA_FRAGMENT_ARGS = "args";
    public final static String BUNDLE_FRAGMENT_CACHE = "cache";
    public final static String BUNDLE_FRAGMENT_ANIM = "anim";

    public static void switchToPage(Context context, int fragmentType, Bundle bundle, int intentFlag, int anim) {
        Intent intent = new Intent(context, SubActivity.class);
        if (intentFlag != 0) {
            intent.setFlags(intentFlag);
        }
        intent.putExtra(INTENT_EXTRA_FRAGMENT_TYPE, fragmentType);
        if (bundle != null) {
            intent.putExtra(INTENT_EXTRA_FRAGMENT_ARGS, bundle);
        }
        if (anim == 1) {
            //有弹出动画
            if (context instanceof MainActivity) {
                MainActivity mainActivity = (MainActivity) context;
                mainActivity.startActivityForResult(intent, Constant.REQUEST_CODE_CITY);
                mainActivity.overridePendingTransition(R.anim.one_in, R.anim.one_out);
            }

        } else if(anim==2){
            if (context instanceof SubActivity) {
                SubActivity subActivity = (SubActivity) context;
                subActivity.startActivityForResult(intent, Constant.REQUEST_CODE);
                subActivity.overridePendingTransition(R.anim.one_in, R.anim.one_out);
            }
        }else {
            if (context instanceof SubActivity) {
                SubActivity subActivity = (SubActivity) context;
                subActivity.startActivityForResult(intent, Constant.REQUEST_CODE);
                subActivity.overridePendingTransition(R.anim.one_in, R.anim.one_out);
            } else if(context instanceof MainActivity){
                MainActivity mainActivity = (MainActivity) context;
                mainActivity.startActivityForResult(intent, Constant.REQUEST_CODE);
                mainActivity.overridePendingTransition(R.anim.one_in, R.anim.one_out);
            }else if(context instanceof Activity){
                Activity activity = (Activity) context;
                activity.overridePendingTransition(R.anim.one_in, R.anim.one_out);
                activity.startActivity(intent);
            }else {
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        }
    }

    public static void switchToPage(Context context, int fragmentType, int anim) {
        switchToPage(context, fragmentType, null, 0, anim);
    }

    public static void switchToPage(Context context, int fragmentType) {
        switchToPage(context, fragmentType, null, 0, -1);
    }

    public static void switchToPage(Context context, int fragmentType, Bundle bundle) {
        switchToPage(context, fragmentType, bundle, 0, -1);
    }
    public static void switchToPage(Context context, int fragmentType, Bundle bundle,int anim) {
        switchToPage(context, fragmentType, bundle, 0, anim);
    }

    /**
     * 传递对象
     *
     * @param context
     * @param info
     */
    public static void siwtchToDetail(Context context, Object info) {
        Bundle args = new Bundle();
        args.putParcelable("key", Parcels.wrap(info));
        PageSwitcherManager.switchToPage(context, FragmentFactory.FRAGMENT_TYPE_MINE_APPLY, args);
    }
}
