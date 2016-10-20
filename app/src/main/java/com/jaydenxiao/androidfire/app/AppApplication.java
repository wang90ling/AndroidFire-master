package com.jaydenxiao.androidfire.app;

import com.jaydenxiao.androidfire.BuildConfig;
import com.jaydenxiao.androidfire.engine.Engine;
import com.jaydenxiao.common.baseapp.BaseApplication;
import com.jaydenxiao.common.commonutils.LogUtils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * APPLICATION
 */
public class AppApplication extends BaseApplication {

    private static AppApplication sInstance;
    private Engine mEngine;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化logger
        LogUtils.logInit(BuildConfig.LOG_DEBUG);

        sInstance = this;
        mEngine = new Retrofit.Builder()
                .baseUrl("http://7xk9dj.com1.z0.glb.clouddn.com/banner/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Engine.class);
    }

    public static AppApplication getInstance() {
        return sInstance;
    }

    public Engine getEngine() {
        return mEngine;
    }
}
