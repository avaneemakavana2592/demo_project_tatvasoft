package com.demo.practical.di.component


import com.demo.practical.di.PerFragment
import com.demo.practical.di.module.FragmentModule
import com.demo.practical.ui.base.BaseFragment
import com.demo.practical.ui.demo.RecyclerViewFragment
import dagger.Subcomponent

/**
 * Created by hlink21 on 31/5/16.
 */

@PerFragment
@Subcomponent(modules = [(FragmentModule::class)])
interface FragmentComponent {
    fun baseFragment(): BaseFragment
    fun inject(recyclerViewFragment: RecyclerViewFragment)
}
