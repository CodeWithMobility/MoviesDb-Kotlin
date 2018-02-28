package com.mobiledev.popularmovies.system

import android.app.Application
import com.mobiledev.popularmovies.di.components.ApplicationComponent
import com.facebook.drawee.backends.pipeline.Fresco
import com.mobiledev.popularmovies.di.components.DaggerApplicationComponent
import com.mobiledev.popularmovies.di.modules.ApplicationModule



/**
 * Created by manu on 2/27/2018.
 */

class MyApp : Application(){
    private var mApplicationComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this)).build()
        mApplicationComponent!!.inject(this)
        Fresco.initialize(this)


    }

    fun getComponent(): ApplicationComponent? {
        return mApplicationComponent
    }


    // Needed to replace the component with a test specific one
    fun setComponent(applicationComponent: ApplicationComponent) {
        mApplicationComponent = applicationComponent
    }
}
