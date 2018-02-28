package com.mobiledev.popularmovies.ui.base

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater

/**
 * Created by manu on 2/27/2018.
 */

abstract class BaseAdapter(activity: BaseActivity) : RecyclerView.Adapter<BaseViewHolder>() {

    var inflater: LayoutInflater
        protected set

    init {
        inflater = LayoutInflater.from(activity)
    }
}