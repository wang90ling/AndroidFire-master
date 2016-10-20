package com.jaydenxiao.androidfire.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.jaydenxiao.androidfire.R;
import com.jaydenxiao.androidfire.factory.FragmentFactory;
import com.jaydenxiao.androidfire.manager.PageSwitcherManager;
import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.base.BaseFragment;

/**
 * Created by wangfengkai on 2016/10/14.
 */
public class SubActivity extends BaseActivity{

    protected final static int LAYOUT_CONTAINER = android.R.id.content;
    private FragmentFactory mFragmentFactory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleIntent(getIntent());
    }

    public FragmentFactory getFragmentFactory() {
        if (mFragmentFactory == null) {
            mFragmentFactory = new FragmentFactory();
        }
        return mFragmentFactory;
    }

    public Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentById(LAYOUT_CONTAINER);
    }

    @Override
    public void onBackPressed() {
        Fragment baseFragment = getCurrentFragment();
        if (baseFragment instanceof BaseFragment) {
            if (((BaseFragment) baseFragment).goBack()) {
                return;
            }
        }
        /* 解决fragment addToBackStack后，按返回键出现空白的Activity问题 */
        if (getSupportFragmentManager().getBackStackEntryCount() <= 1) {
            finish();
        } else {
            try {
                super.onBackPressed();
            } catch (Exception e) {
                //LogUtils.e(e);
            }
        }
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.two_in, R.anim.two_out);
    }


    public void handleIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        setIntent(intent);

        int type = intent.getIntExtra(PageSwitcherManager.INTENT_EXTRA_FRAGMENT_TYPE, 0);
        Bundle args = intent.getBundleExtra(PageSwitcherManager.INTENT_EXTRA_FRAGMENT_ARGS);
        boolean useCache = false;
        boolean useAnim = false;

        if (args != null) {
            useCache = args.getBoolean(PageSwitcherManager.BUNDLE_FRAGMENT_CACHE);
            useAnim = args.getBoolean(PageSwitcherManager.BUNDLE_FRAGMENT_ANIM);
        } else {
            args = new Bundle();
            final Bundle extras = intent.getExtras();
            if (extras != null) {
                args.putAll(intent.getExtras());
            }
        }

        if (!useAnim) {
            //LogManager.d("push fragment %s, cache %s, anim %s", type, useCache, false);
            pushFragment(type, args, LAYOUT_CONTAINER, useCache, false);

        } else {
           // LogManager.d("push fragment %s, cache %s, anim %s", type, useCache, true);
            pushFragment(type, args, LAYOUT_CONTAINER, useCache, true);
        }
    }


    /**
     * 将fragment加到backStack
     *
     * @param type      Fragment对应的clazz
     * @param args      Fragment参数
     * @param container 放置Fragment的View节点
     * @param useCache  是否缓存，如果缓存则使用完需要调用removeFragment清除缓存
     * @param useAnim   是否播放切换动画
     */
    protected void pushFragment(int type, Bundle args, int container, boolean useCache, boolean useAnim) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fT = fragmentManager.beginTransaction();

        if (useAnim) {
            fT.setCustomAnimations(R.anim.open_slide_in, R.anim.open_slide_out,
                    R.anim.close_slide_in, R.anim.close_slide_out);
        }

        Fragment fragment = null;
        if (useCache) {
            fragment = fragmentManager.findFragmentByTag(String.valueOf(type));
            if (fragment == null) {
                fragment = (Fragment) getFragmentFactory().getFragment(type, true);
            }

        } else {
            removeFragment(type);
            fragment = getFragmentFactory().getFragment(type, false);
        }

        if (fragment == fragmentManager.findFragmentById(container)) {
            return;
        }

        if (fragment != null) {
            if (args != null) {
                ((BaseFragment) fragment).setArguments(args);
            }

            fT.replace(container, fragment, String.valueOf(type));
            fT.addToBackStack(String.valueOf(type));
        }

        fT.commitAllowingStateLoss();
    }


    /**
     * 从缓存中移除Fragment
     *
     * @param type
     */
    public void removeFragment(int type) {
        getFragmentFactory().removeFragment(type);
    }

    /**
     * 向当前Fragment分发onActivityResult事件
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //LogManager.i("SubActivity onActivityResult");
        Fragment f = getCurrentFragment();
        f.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

    }
}
