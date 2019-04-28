package com.dubai.dubailaundry.di.component;


import com.dubai.dubailaundry.common.BaseActivity;
import com.dubai.dubailaundry.di.scope.ActivityScope;
import com.dubai.dubailaundry.utils.AppPrefes;
import com.dubai.dubailaundry.utils.UtilsPref;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class)
public interface ActivityComponent extends AppComponent {
    void inject(BaseActivity baseActivity);

    void inject(UtilsPref utilsPref);

    void inject(AppPrefes appPrefes);
}