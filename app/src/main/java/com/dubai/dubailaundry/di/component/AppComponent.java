package com.dubai.dubailaundry.di.component;

import android.content.Context;


import com.dubai.dubailaundry.di.module.ApplicationModule;
import com.dubai.dubailaundry.utils.AppPrefes;
import com.dubai.dubailaundry.utils.UtilsPref;
import com.dubai.dubailaundry.utils.api.ApiCalls;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {ApplicationModule.class})
public interface AppComponent {
    Context appContext();

    UtilsPref appUtilsPref();

    AppPrefes appAppPrefes();

    ApiCalls appApiCalls();
}
