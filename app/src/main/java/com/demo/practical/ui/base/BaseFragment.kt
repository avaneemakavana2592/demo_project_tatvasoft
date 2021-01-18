package com.demo.practical.ui.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.demo.practical.di.HasComponent
import com.demo.practical.di.component.ActivityComponent
import com.demo.practical.di.component.FragmentComponent
import com.demo.practical.di.module.FragmentModule

/**
 * Created by hlink21 on 25/4/16.
 */
abstract class BaseFragment : Fragment(), HasComponent<FragmentComponent> {


    protected lateinit var toolbar: HasToolbar


    override val component: FragmentComponent
        get() {
            return getComponent(ActivityComponent::class.java).plus(FragmentModule(this))
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(createLayout(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bindData()
    }

    protected fun <C> getComponent(componentType: Class<C>): C {
        return componentType.cast((activity as HasComponent<C>).component)
    }

    override fun onAttach(context: Context) {
        inject(component)
        super.onAttach(context)

        if (activity is HasToolbar)
            toolbar = activity as HasToolbar


    }


    fun hideKeyBoard() {
        if (activity is BaseActivity) {
            (activity as BaseActivity).hideKeyboard()
        }
    }

    fun showKeyBoard() {
        if (activity is BaseActivity) {
            (activity as BaseActivity).showKeyboard()
        }
    }


    fun <T : BaseFragment> getParentFragment(targetFragment: Class<T>): T? {
        if (parentFragment == null) return null
        try {
            return targetFragment.cast(parentFragment)
        } catch (e: ClassCastException) {
            e.printStackTrace()
        }

        return null
    }

    open fun onShow() {

    }

    open fun onBackActionPerform(): Boolean {
        return true
    }

    open fun onViewClick(view: View) {

    }

    public fun onError(throwable: Throwable) {
        Log.e(javaClass.simpleName, "Error From Base framework ", throwable)
    }

    protected abstract fun createLayout(): Int
    protected abstract fun inject(fragmentComponent: FragmentComponent)
    protected abstract fun bindData()

}
