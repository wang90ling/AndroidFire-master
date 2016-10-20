package com.jaydenxiao.androidfire.ui.resource.fragment;

import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jaydenxiao.androidfire.R;
import com.jaydenxiao.common.base.BaseFragment;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by wangfengkai on 2016/10/14.
 */
public class DefaultFragment extends BaseFragment {

    @Bind(R.id.tv_title_center)
    TextView tv_title_center;
    @Bind(R.id.rl_title_left)
    RelativeLayout rl_title_left;

    public static DefaultFragment newInstance() {
        return new DefaultFragment();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_default;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        tv_title_center.setText("Demo实例");

    }

    @OnClick(R.id.rl_title_left)
    public void goback(){
        getActivity().finish();
    }


}
