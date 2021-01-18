package com.demo.practical.di.module

import com.demo.practical.di.PerFragment
import com.demo.practical.ui.base.BaseFragment
import dagger.Module
import dagger.Provides

/**
 * Created by hlink21 on 31/5/16.
 */
@Module
class FragmentModule(private val baseFragment: BaseFragment) {

    @Provides
    @PerFragment
    internal fun provideBaseFragment(): BaseFragment {
        return baseFragment
    }

}
