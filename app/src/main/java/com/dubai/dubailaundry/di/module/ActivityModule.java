package com.dubai.dubailaundry.di.module;


import com.dubai.dubailaundry.common.BaseActivity;

import dagger.Module;

@Module
public class ActivityModule {
    private BaseActivity baseActivity;

    public ActivityModule(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
    }

}
