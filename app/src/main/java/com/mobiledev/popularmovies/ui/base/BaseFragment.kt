package com.mobiledev.popularmovies.ui.base

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.view.View

import com.mobiledev.popularmovies.R
import com.mobiledev.popularmovies.di.components.ActivityComponent


import io.reactivex.annotations.Nullable


/**
 * Created by manu on 2/27/2018.
 */
abstract class BaseFragment : Fragment(), MvpView {

    var baseActivity: BaseActivity? = null
        private set
     private var mProgressDialog: ProgressDialog? = null
    var productIndex: Int = 0
    var obj : Any? = null

    override val isNetworkConnected: Boolean
        get() = if (baseActivity != null) {
            baseActivity!!.isNetworkConnected
        } else false

    val activityComponent: ActivityComponent?
        get() = if (baseActivity != null) {
            baseActivity!!.activityComponent
        } else null

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseActivity = activity as BaseActivity
        setHasOptionsMenu(false)
    }

    override fun onViewCreated(view: View?, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(view)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            this.baseActivity = context
            baseActivity!!.onFragmentAttached()
        }
    }

    override fun showLoading() {
        hideLoading()
        mProgressDialog = ProgressDialog(this.context)
        mProgressDialog!!.show()
        if (mProgressDialog!!.window != null) {
            mProgressDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        mProgressDialog!!.setContentView(R.layout.progress_dialog)
        mProgressDialog!!.isIndeterminate = true
        mProgressDialog!!.setCancelable(false)
        mProgressDialog!!.setCanceledOnTouchOutside(false)
    }

    override fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.cancel()
        }
    }

    override fun onError(message: String) {
        if (baseActivity != null) {
            baseActivity!!.onError(message)
        }
    }

    override fun onError(@StringRes resId: Int) {
        if (baseActivity != null) {
            baseActivity!!.onError(resId)
        }
    }

    override fun showMessage(message: String) {
        if (baseActivity != null) {
            baseActivity!!.showMessage(message)
        }
    }

    override fun showMessage(@StringRes resId: Int) {
        if (baseActivity != null) {
            baseActivity!!.showMessage(resId)
        }
    }

    override fun onDetach() {
        baseActivity = null
        super.onDetach()
    }

    override fun hideKeyboard() {
        if (baseActivity != null) {
            baseActivity!!.hideKeyboard()
        }
    }

    fun setProductTagIndex(productIndex: Int, obj: Any) {
        this.productIndex = productIndex
        this.obj = obj
    }



    protected abstract fun setUp(view: View?)

    override fun onDestroy() {

        super.onDestroy()
    }

    interface Callback {

        fun onFragmentAttached()

        fun onFragmentDetached(tag: String)
    }
}