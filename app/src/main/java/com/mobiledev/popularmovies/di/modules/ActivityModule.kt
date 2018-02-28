package com.mobiledev.popularmovies.di.modules

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager

import com.mobiledev.popularmovies.di.scope.ActivityContext
import com.mobiledev.popularmovies.di.scope.PerActivity
import com.mobiledev.popularmovies.ui.landing.LandingPresenter
import com.mobiledev.popularmovies.ui.landing.LandingPresenterImpl
import com.mobiledev.popularmovies.ui.landing.LandingView
import com.mobiledev.popularmovies.ui.popular.PopularPresenter
import com.mobiledev.popularmovies.ui.popular.PopularPresenterImpl
import com.mobiledev.popularmovies.ui.popular.PopularView

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import com.mobiledev.popularmovies.ui.base.BaseActivity
import com.mobiledev.popularmovies.ui.nowplaying.NowPlayingAdapter
import com.mobiledev.popularmovies.ui.nowplaying.NowPlayingPresenter
import com.mobiledev.popularmovies.ui.nowplaying.NowPlayingPresenterImpl
import com.mobiledev.popularmovies.ui.nowplaying.NowPlayingView
import com.mobiledev.popularmovies.ui.popular.PopularAdapter
import com.mobiledev.popularmovies.ui.toprated.TopRatedAdapter
import com.mobiledev.popularmovies.ui.toprated.TopRatedPresenter
import com.mobiledev.popularmovies.ui.toprated.TopRatedPresenterImpl
import com.mobiledev.popularmovies.ui.toprated.TopRatedView
import com.mobiledev.popularmovies.ui.upcoming.UpComingAdapter
import com.mobiledev.popularmovies.ui.upcoming.UpComingPresenter
import com.mobiledev.popularmovies.ui.upcoming.UpComingPresenterImpl
import com.mobiledev.popularmovies.ui.upcoming.UpComingView


/**
 * Created by manu on 2/27/2018.
 */

@Module
class ActivityModule(private val mActivity: AppCompatActivity) {

    @Provides
    @ActivityContext
    fun provideContext(): Context {
        return mActivity
    }

    @Provides
    fun provideActivity(): AppCompatActivity {
        return mActivity
    }

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    //    @Provides
    //    @PerActivity
    //    SplashPresenter<SplashView> provideSplashPresenter(
    //            SplashPresenterImpl<SplashView> presenter) {
    //        return presenter;
    //    }



    @Provides
    @PerActivity
    fun provideLandingPresenter(
            presenter: LandingPresenterImpl<LandingView>): LandingPresenter<LandingView> {
        return presenter
    }

    @Provides
    @PerActivity
    fun providePopularPresenter(
            presenter: PopularPresenterImpl<PopularView>): PopularPresenter<PopularView> {
        return presenter
    }

    @Provides
    @PerActivity
    fun provideUpComingPresenter(
            presenter: UpComingPresenterImpl<UpComingView>): UpComingPresenter<UpComingView> {
        return presenter
    }

    @Provides
    @PerActivity
    fun provideNowPlayingPresenter(
            presenter: NowPlayingPresenterImpl<NowPlayingView>): NowPlayingPresenter<NowPlayingView> {
        return presenter
    }

    @Provides
    @PerActivity
    fun provideTopRatedPresenter(
            presenter: TopRatedPresenterImpl<TopRatedView>): TopRatedPresenter<TopRatedView> {
        return presenter
    }


    @Provides
    fun providePopularAdapter(): PopularAdapter {
        return PopularAdapter(mActivity as BaseActivity)
    }

    @Provides
    fun provideTopRatedAdapter(): TopRatedAdapter {
        return TopRatedAdapter(mActivity as BaseActivity)
    }

    @Provides
    fun provideNowPlayingAdapter(): NowPlayingAdapter {
        return NowPlayingAdapter(mActivity as BaseActivity)
    }

    @Provides
    fun provideUpComingAdapter(): UpComingAdapter {
        return UpComingAdapter(mActivity as BaseActivity)
    }


    @Provides
    fun provideGridLayoutManager(activity: AppCompatActivity): GridLayoutManager {
        return GridLayoutManager(activity, 2)
    }

    @Provides
    fun provideLinearLayoutManager(activity: AppCompatActivity): LinearLayoutManager {
        return LinearLayoutManager(activity)
    }
}