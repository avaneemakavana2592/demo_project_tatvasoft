package com.demo.practical.ui.demo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.demo.practical.R
import com.demo.practical.data.pojo.User
import com.demo.practical.ui.Utility.SpacesItemDecoration
import com.demo.practical.ui.Utility.advance_adapter.adapter.AdvanceRecycleViewAdapter
import com.demo.practical.ui.Utility.advance_adapter.base.BaseHolder
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.row_profile.view.*


class ImageAdapter(val context: Context) : AdvanceRecycleViewAdapter<ImageAdapter.ImageViewHolder, User>() {


    override fun createDataHolder(parent: ViewGroup?, viewType: Int): ImageViewHolder? {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.row_profile, parent, false)
        return ImageViewHolder(itemView!!)
    }

    override fun onBindDataHolder(holder: ImageViewHolder?, position: Int, item: User?) {
//        holder?.setIsRecyclable(false)
        holder?.let {
            it.bindData(item!!)
        }
    }

    override fun getViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    inner class ImageViewHolder(override val containerView: View) : BaseHolder<User>(containerView), LayoutContainer {

        val imageViewUser = containerView.findViewById<AppCompatImageView>(R.id.imageViewUser)
        val imageView = containerView.findViewById<AppCompatImageView>(R.id.imageView)
        val textViewUserName = containerView.findViewById<AppCompatTextView>(R.id.textViewUserName)
        val recyclerViewGrid = containerView.findViewById<RecyclerView>(R.id.recyclerViewGrid)

        fun bindData(user: User) {
            Glide.with(containerView).load(user.image).apply(RequestOptions.circleCropTransform()).into(imageViewUser)
            textViewUserName.text = user.name
            val images = user.items
            if (images.size % 2 == 0) {
                var imageList = ArrayList<String>()
                containerView.recyclerViewGrid.visibility = View.VISIBLE
                imageList.addAll(images)
                imageView.visibility = View.GONE
                val gridAdapter = GridAdapter()
                val gridLayoutManager = GridLayoutManager(containerView.context, 2)
                recyclerViewGrid.apply {
                    this.layoutManager = gridLayoutManager
                    this.adapter = gridAdapter
                }
                gridAdapter.items = imageList
                recyclerViewGrid.addItemDecoration(SpacesItemDecoration(0))
            } else {
                containerView.recyclerViewGrid.visibility = View.VISIBLE
                val a = images.get(0)
                images.remove(a)
                var imageList = ArrayList<String>()
                imageList.addAll(images)
                imageView.visibility = View.VISIBLE
                Glide.with(containerView).load(a).into(imageView)
                if (images.size != 1) {
                    val gridAdapter = GridAdapter()
                    val gridLayoutManager = GridLayoutManager(containerView.context, 2)
                    recyclerViewGrid.apply {
                        this.layoutManager = gridLayoutManager
                        this.adapter = gridAdapter
                    }
                    recyclerViewGrid.setHasFixedSize(true)
                    gridAdapter.items = imageList
                    recyclerViewGrid.addItemDecoration(SpacesItemDecoration(0))
                }
            }

        }
    }


}
