package com.mobiledev.popularmovies.di.components


import com.mobiledev.popularmovies.di.modules.ActivityModule
import com.mobiledev.popularmovies.di.scope.PerActivity
import com.mobiledev.popularmovies.ui.landing.LandingActivity
import com.mobiledev.popularmovies.ui.nowplaying.NowPlayingFragment
import com.mobiledev.popularmovies.ui.popular.PopularFragment
import com.mobiledev.popularmovies.ui.toprated.TopRatedFragment
import com.mobiledev.popularmovies.ui.upcoming.UpComingFragment

import dagger.Component

/**
 * Created by manu on 2/27/2018.
 */

@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {


    fun inject(activity: LandingActivity)

    fun inject(fragment: PopularFragment)

    fun inject(fragment: TopRatedFragment)

    fun inject(fragment: UpComingFragment)

    fun inject(fragment: NowPlayingFragment)
}