package com.mobiledev.popularmovies.di.components

/**
 * Created by manu on 2/27/2018.
 */

import android.app.Application
import android.content.Context

import com.mobiledev.popularmovies.di.modules.ApplicationModule
import com.mobiledev.popularmovies.di.scope.ApplicationContext
import com.mobiledev.popularmovies.system.MyApp

import javax.inject.Singleton

import dagger.Component
import com.mobiledev.popularmovies.data.DataManager





/**
 * Created by manu on 2/18/2018.
 */

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(app: MyApp)

    @ApplicationContext
    fun context(): Context

    fun application(): Application


    fun getDataManager(): DataManager
}