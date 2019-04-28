package com.dubai.dubailaundry.di.module;

import android.content.Context;

import com.dubai.dubailaundry.App;
import com.dubai.dubailaundry.utils.AppPrefes;
import com.dubai.dubailaundry.utils.UtilsPref;
import com.dubai.dubailaundry.utils.api.ApiCalls;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;






@Module
public class ApplicationModule {

    private final App mApp;

    public ApplicationModule(App app) {
        mApp = app;
    }

    @Provides
    @Singleton
    public Context appContext() {
        return mApp;
    }

    @Provides
    @Singleton
    public UtilsPref appUtilsPref() {
        return new UtilsPref(mApp.getActivityComponent());
    }

    @Provides
    @Singleton
    public AppPrefes appAppPrefes() {
        return new AppPrefes(appContext().getApplicationContext());
    }

    @Provides
    @Singleton
    public ApiCalls appApiCalls() {
        return new ApiCalls();
    }
}
