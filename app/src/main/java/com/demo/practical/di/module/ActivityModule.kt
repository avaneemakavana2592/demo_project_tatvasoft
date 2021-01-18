package com.demo.practical.di.module

import com.demo.practical.di.PerActivity
import com.demo.practical.ui.base.BaseActivity
import com.demo.practical.ui.manager.FragmentHandler
import com.demo.practical.ui.manager.Navigator

import javax.inject.Named

import dagger.Module
import dagger.Provides

/**
 * Created by hlink21 on 9/5/16.
 */
@Module
class ActivityModule {

    @Provides
    @PerActivity
    internal fun navigator(activity: BaseActivity): Navigator {
        return activity
    }

    @Provides
    @PerActivity
    internal fun fragmentManager(baseActivity: BaseActivity): androidx.fragment.app.FragmentManager {
        return baseActivity.supportFragmentManager
    }

    @Provides
    @PerActivity
    @Named("placeholder")
    internal fun placeHolder(baseActivity: BaseActivity): Int {
        return baseActivity.findFragmentPlaceHolder()
    }

    @Provides
    @PerActivity
    internal fun fragmentHandler(fragmentManager: com.demo.practical.ui.manager.FragmentManager): FragmentHandler {
        return fragmentManager
    }


}
