package com.demo.practical.di.component


import com.demo.practical.HomeActivity
import com.demo.practical.di.PerActivity
import com.demo.practical.di.module.ActivityModule
import com.demo.practical.di.module.FragmentModule
import com.demo.practical.ui.base.BaseActivity
import com.demo.practical.ui.manager.Navigator
import dagger.BindsInstance
import dagger.Component

/**
 * Created by hlink21 on 9/5/16.
 */
@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun activity(): BaseActivity

    fun navigator(): Navigator


    operator fun plus(fragmentModule: FragmentModule): FragmentComponent

    fun inject(homeActivity: HomeActivity)

    @Component.Builder
    interface Builder {

        fun bindApplicationComponent(applicationComponent: ApplicationComponent): Builder

        @BindsInstance
        fun bindActivity(baseActivity: BaseActivity): Builder

        fun build(): ActivityComponent
    }
}
