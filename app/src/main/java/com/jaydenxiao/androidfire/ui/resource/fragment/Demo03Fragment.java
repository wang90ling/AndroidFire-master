package com.jaydenxiao.androidfire.ui.resource.fragment;

import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jaydenxiao.androidfire.R;
import com.jaydenxiao.common.base.BaseFragment;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by wangfengkai on 2016/10/14.
 */
public class Demo03Fragment extends BaseFragment {

    @Bind(R.id.tv_title_center)
    TextView tv_title_center;
    @Bind(R.id.rl_title_left)
    RelativeLayout rl_title_left;
    @Bind(R.id.tv_check_version_update)
    TextView tv_check_version_update;

    public static Demo03Fragment newInstance() {
        return new Demo03Fragment();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_demo03;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        tv_title_center.setText("APP版本更新");

    }

    @OnClick(R.id.rl_title_left)
    public void goback(){
        getActivity().finish();
    }


    @OnClick(R.id.tv_check_version_update)
    public void checkVersionUpdate(){
        System.out.println("检测版本更新");
        Toast.makeText(getContext(),"检测版本更新",Toast.LENGTH_SHORT).show();
    }

}
