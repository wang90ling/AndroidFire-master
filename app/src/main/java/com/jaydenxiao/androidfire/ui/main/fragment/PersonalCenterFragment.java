package com.jaydenxiao.androidfire.ui.main.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jaydenxiao.androidfire.R;
import com.jaydenxiao.androidfire.factory.FragmentFactory;
import com.jaydenxiao.androidfire.manager.PageSwitcherManager;
import com.jaydenxiao.androidfire.ui.news.activity.AboutActivity;
import com.jaydenxiao.androidfire.ui.zone.activity.CircleZoneActivity;
import com.jaydenxiao.common.base.BaseFragment;
import com.jaydenxiao.common.commonwidget.NormalTitleBar;
import com.jaydenxiao.common.daynightmodeutils.ChangeModeController;

import butterknife.Bind;
import butterknife.OnClick;
import me.shaohui.bottomdialog.BottomDialog;

/**
 * des:关注主页
 * Created by xsf
 * on 2016.09.17:07
 */
public class PersonalCenterFragment extends BaseFragment {
    @Bind(R.id.ntb)
    NormalTitleBar ntb;
    @Bind(R.id.ll_contact_us)
    LinearLayout ll_contact_us;

    @Override
    protected int getLayoutResource() {
        return R.layout.fra_personal_center_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        ntb.setTvLeftVisiable(false);
        ntb.setTitleText("我的");
    }

    @OnClick(R.id.ll_contact_us)
    public void contactUS(){  //联系我们
        showDialog();
        //Toast.makeText(getContext(),"联系我们",Toast.LENGTH_SHORT).show();
    }

    private void showDialog() {  //FragmentManager
        BottomDialog.create(getFragmentManager())
                .setViewListener(new BottomDialog.ViewListener() {
                    @Override
                    public void bindView(View v) {
                        initView(v);
                    }
                })
                .setLayoutRes(R.layout.dialog_layout)
                .setDimAmount(0.5f)
                .setTag("BottomDialog")
                .show();
    }

    private void initView(final View view) {

    }
}
