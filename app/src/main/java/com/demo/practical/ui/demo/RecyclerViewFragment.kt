package com.demo.practical.ui.demo

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.demo.practical.R
import com.demo.practical.data.pojo.ImageData
import com.demo.practical.data.pojo.User
import com.demo.practical.di.component.FragmentComponent
import com.demo.practical.ui.Utility.ApiClient
import com.demo.practical.ui.Utility.advance_adapter.EndlessRecyclerViewScrollListener
import com.demo.practical.ui.base.BaseFragment
import com.demo.practical.ui.demo.adapter.ImageAdapter
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_recycler_view.*
import javax.inject.Inject


class RecyclerViewFragment : BaseFragment() {

    var hasMore = true

    lateinit var imageAdapter: ImageAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    lateinit var imageList: ArrayList<User>

    lateinit var endlessRecyclerViewScrollListener: EndlessRecyclerViewScrollListener

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun createLayout(): Int = R.layout.fragment_recycler_view

    override fun inject(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun bindData() {
        imageList = ArrayList()

        imageAdapter = ImageAdapter(context!!)
        linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.apply {
            this.layoutManager = linearLayoutManager
            this.adapter = imageAdapter
        }
        getImage(1, 10)

        endlessRecyclerViewScrollListener = object : EndlessRecyclerViewScrollListener(linearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int) {
                if (page != 1 && hasMore) {
                    getImage(10 * page, 10)
                }
            }
        }
        recyclerView.addOnScrollListener(endlessRecyclerViewScrollListener)

        swipeRefresh.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener {
            override fun onRefresh() {
                hasMore = true
                swipeRefresh.isRefreshing = true
                imageList.clear()
                getImage(1, 10)
            }
        })
    }


    private fun getImage(offset: Int, limit: Int) {

        ApiClient.getInstance()
                .getUsers(offset, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<ImageData> {
                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(t: ImageData) {
                        if (swipeRefresh.isRefreshing) {
                            swipeRefresh.isRefreshing = false
                        }
                        hasMore = t.data.has_more
                        Log.e("Scheduke", t.toString())
                        imageList.addAll(t.data.users)
                        imageAdapter.items = imageList
                        imageAdapter.notifyDataSetChanged()
                    }

                    override fun onError(e: Throwable) {
                        Log.e("ewrror", e.message)
                    }
                })


//        val userViewModel = ViewModelProviders.of(this, viewModelFactory)[UserViewModel::class.java]
//        userViewModel.userLiveData.observe(this, { responsebody ->
//
//            userViewModel.userLiveData.removeObservers(this)
//        }, { throwable: Throwable, responseBody: ResponseBody<Data>? ->
//            userViewModel.userLiveData.removeObservers(this)
//            true
//        })
//        userViewModel.getImages()

    }
}
