package com.mobiledev.popularmovies.ui.base

import android.annotation.TargetApi
import android.app.ProgressDialog
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

import com.mobiledev.popularmovies.R
import com.mobiledev.popularmovies.di.components.ActivityComponent
import com.mobiledev.popularmovies.di.components.DaggerActivityComponent
import com.mobiledev.popularmovies.di.modules.ActivityModule
import com.mobiledev.popularmovies.system.MyApp

import io.reactivex.annotations.Nullable

/**
 * Created by manu on 2/27/2018.
 */

abstract class BaseActivity : AppCompatActivity(), MvpView, BaseFragment.Callback {

    var activityComponent: ActivityComponent? = null
        private set
    private var mProgressDialog: ProgressDialog? = null

    override val isNetworkConnected: Boolean
        get() = true

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .applicationComponent((application as MyApp).getComponent())
                .build()

    }

    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }

    override fun showLoading() {
        hideLoading()
        mProgressDialog = ProgressDialog(this)
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
        if (message != null) {
            showMessage(message)
        } else {
            showMessage(getString(R.string.some_error))
        }
    }

    override fun onError(@StringRes resId: Int) {
        onError(getString(resId))
    }

    override fun showMessage(message: String) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_SHORT).show()
        }
    }

    override fun showMessage(@StringRes resId: Int) {
        showMessage(getString(resId))
    }

    override fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }


    override fun onDestroy() {

        super.onDestroy()
    }

    override fun onFragmentAttached() {}

    override fun onFragmentDetached(tag: String) {}

}