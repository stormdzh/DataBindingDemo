package com.stormdzh.myapplication;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @Description: 描述
 * @Author: dzh
 * @CreateDate: 2021-01-01 10:23
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
