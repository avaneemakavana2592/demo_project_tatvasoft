package com.demo.practical

import android.os.Bundle
import com.demo.practical.di.component.ActivityComponent
import com.demo.practical.ui.base.BaseActivity
import com.demo.practical.ui.demo.RecyclerViewFragment

class HomeActivity : BaseActivity() {

    override fun findFragmentPlaceHolder(): Int = R.id.placeHolder

    override fun findContentView(): Int = R.layout.activity_home

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        load(RecyclerViewFragment::class.java).add(false)
    }
}