package com.mobiledev.popularmovies.ui.base

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by manu on 2/27/2018.
 */

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(model: Any)

}