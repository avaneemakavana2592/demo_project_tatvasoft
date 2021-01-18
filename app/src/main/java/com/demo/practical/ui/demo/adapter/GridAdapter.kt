package com.demo.practical.ui.demo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.demo.practical.R
import com.demo.practical.ui.Utility.advance_adapter.adapter.AdvanceRecycleViewAdapter
import com.demo.practical.ui.Utility.advance_adapter.base.BaseHolder
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.row_image_1.view.*


class GridAdapter : AdvanceRecycleViewAdapter<GridAdapter.GridViewHolder, String>() {

    override fun createDataHolder(parent: ViewGroup?, viewType: Int): GridViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.row_image_1, parent, false)
        return GridViewHolder(itemView)
    }

    override fun onBindDataHolder(holder: GridViewHolder?, position: Int, string: String) {
        holder?.let {
            it.bindData(string)
        }
    }

    override fun getViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    inner class GridViewHolder(override val containerView: View) : BaseHolder<String>(containerView), LayoutContainer {

        fun bindData(url: String) {
            Glide.with(containerView).load(url).into(containerView.imageView1)
        }
    }

}