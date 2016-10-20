package com.jaydenxiao.androidfire.ui.main.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.jaydenxiao.androidfire.R;
import com.jaydenxiao.androidfire.config.SharePrefConstant;
import com.jaydenxiao.androidfire.manager.SharePrefManager;
import com.jaydenxiao.common.base.BaseActivity;

import java.util.logging.Handler;

/**
 * 欢迎界面
 */
public class WelcomeActivity extends BaseActivity {

    private boolean isFirst;
    private static int TIME = 1000;

    @Override
    public int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initPresenter() {
        //判断是否是第一次安装并使用该APP
        isFirst = SharePrefManager.getBoolean("First", true);

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                String token = SharePrefManager.getString(SharePrefConstant.KEY_APP_TOKEN, "");
                //如果第一次，则进入引导页WelcomeActivity
                if (isFirst) {
                    intent = new Intent(WelcomeActivity.this, GuideActivity.class);
                    startActivity(intent);
                } else {
                    //说明用户已经登录过了
                    if (token != null && !TextUtils.isEmpty(token)) {
                        intent = new Intent(WelcomeActivity.this, MainActivity.class);
                        startActivity(intent);
                        //说明用户已经登录过了
                    } else {
                       // PageSwitcherManager.switchToPage(WelcomeActivity.this, FragmentFactory.FRAGMENT_TYPE_LOGIN);

                        Intent intent2 = new Intent(WelcomeActivity.this, MainActivity.class);
                        startActivity(intent2);
                    }
                }
                overridePendingTransition(R.anim.one_in, R.anim.one_out);
                finish();
            }
        }, TIME);

    }

    @Override
    public void initView() {

    }
}
