package com.jaydenxiao.androidfire.factory;

import android.util.SparseArray;

import com.jaydenxiao.androidfire.base.WebViewFragment;
import com.jaydenxiao.androidfire.ui.resource.fragment.DefaultFragment;
import com.jaydenxiao.androidfire.ui.resource.fragment.Demo01Fragment;
import com.jaydenxiao.androidfire.ui.resource.fragment.Demo02Fragment;
import com.jaydenxiao.androidfire.ui.resource.fragment.Demo03Fragment;
import com.jaydenxiao.androidfire.ui.resource.fragment.DemoListFragment;
import com.jaydenxiao.androidfire.ui.resource.fragment.LearnResourceFragment;
import com.jaydenxiao.androidfire.ui.resource.fragment.ResourceOneFragment;
import com.jaydenxiao.common.base.BaseFragment;

/**
 * Created by wangfengkai on 2016/10/14.
 */
public class FragmentFactory {

    public static final int FRAGMENT_TYPE_LOGIN = 0x00;//登陆
    public static final int FRAGMENT_TYPE_MINE_APPLY = 0x01; // 我要报名
    public static final int FRAGMENT_TYPE_LEARNRESOURCE = 0x02;  //资源分享
    public static final int FRAGMENT_TYPE_RESOURCEONE = 0x03;  //资源分类一
    public static final int FRAGMENT_TYPE_WEBVIEW = 0x04;  //网页fragment
    public static final int FRAGMENT_TYPE_DEMOLIST = 0x05;  //demo列表
    public static final int FRAGMENT_TYPE_DEMO01 = 0x06;  //demo01
    public static final int FRAGMENT_TYPE_DEMO02 = 0x07;  //demo02
    public static final int FRAGMENT_TYPE_DEMO03 = 0x08;  //demo03

    private SparseArray<BaseFragment> mFragmentCache = new SparseArray<BaseFragment>();

    public BaseFragment getFragment(int type, boolean useCache) {

        BaseFragment fragment = null;
        useCache = false;

        if (useCache && (fragment = mFragmentCache.get(type)) != null) {
            return fragment;
        }

        switch (type) {
            case FragmentFactory.FRAGMENT_TYPE_MINE_APPLY:
                fragment = DefaultFragment.newInstance();
                break;
            case FragmentFactory.FRAGMENT_TYPE_LEARNRESOURCE:
                fragment = LearnResourceFragment.newInstance();
                break;

            case FragmentFactory.FRAGMENT_TYPE_RESOURCEONE:
                fragment = ResourceOneFragment.newInstance();
                break;

            case FragmentFactory.FRAGMENT_TYPE_WEBVIEW:
                fragment = WebViewFragment.newInstance();
                break;

            case FragmentFactory.FRAGMENT_TYPE_DEMOLIST:
                fragment = DemoListFragment.newInstance();
                break;

            case FragmentFactory.FRAGMENT_TYPE_DEMO01:
                fragment = Demo01Fragment.newInstance();
                break;

            case FragmentFactory.FRAGMENT_TYPE_DEMO02:
                fragment = Demo02Fragment.newInstance();
                break;

            case FragmentFactory.FRAGMENT_TYPE_DEMO03:
                fragment = Demo03Fragment.newInstance();
                break;
          /*  case FragmentFactory.FRAGMENT_TYPE_LOGIN:
                fragment = LoginFragment.newInstance();
                break;*/
        }
        if (useCache) {
            mFragmentCache.put(type, fragment);
        }
        return fragment;
    }

    public void removeFragment(int type) {
        mFragmentCache.remove(type);
    }

    public BaseFragment getFragmentFromCache(int type) {
        return mFragmentCache.get(type);
    }

    public void clearCache() {
        mFragmentCache.clear();
    }
}
