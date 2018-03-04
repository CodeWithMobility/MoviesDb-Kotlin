package com.mobiledev.popularmovies.di.modules

/**
 * Created by manu on 2/27/2018.
 */

import android.app.Application
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.mobiledev.popularmovies.BuildConfig
import com.mobiledev.popularmovies.di.scope.ApplicationContext

import java.util.concurrent.TimeUnit

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.mobiledev.popularmovies.data.AppDataManager
import com.mobiledev.popularmovies.data.DataManager
import com.mobiledev.popularmovies.data.local.DatabaseHelper
import com.mobiledev.popularmovies.data.local.IDBHelper
import com.mobiledev.popularmovies.data.local.LocalDatabase
import com.mobiledev.popularmovies.data.network.AppApiHelper
import com.mobiledev.popularmovies.data.network.IApiHelper





/**
 * Created by manu on 2/18/2018.
 */

@Module
class ApplicationModule(private val mApplication: Application) {

    /****
     * providing Context
     */
    @Provides
    @ApplicationContext
    fun provideContext(): Context {
        return mApplication
    }

    /****
     * providing application context
     */
    @Provides
    fun provideApplication(): Application {
        return mApplication
    }

    /****
     * Providing DataManager
     */
    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    /*****
     * Providing APIHelper interface
     */
    @Provides
    @Singleton
    fun provideApiHelper(appApiHelper: AppApiHelper): IApiHelper {
        return appApiHelper
    }

    /***
     * Providing for Caching object
     */
    @Provides
    @Singleton
    fun provideHttpCache(application: Application): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize.toLong())
    }


    /***
     * Providing for Gson object
     */
    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }

    /***
     * Providing for LoggingInterceptor object
     */
    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    fun provideClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS).build()
        httpClient.addInterceptor(interceptor)
        return httpClient.build()
    }

    /***
     * Providing for Retrofit object
      */
    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .baseUrl(BuildConfig.BASE_URL)
                .build()
    }

    /***
     * Providing for Shared Preference
     */
    @Provides
    @Singleton
    fun providesSharedPreferences(application: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

    /****
     * Providing object of Local db
     */
    @Provides
    @Singleton
    fun provideDBHelper(databaseHelper: DatabaseHelper): IDBHelper {
        return databaseHelper
    }

    /****
     * Providing object of RoomDatabse
     */
    @Provides
    @Singleton
    fun provideDatabase(): RoomDatabase {
        return Room.databaseBuilder(mApplication, LocalDatabase::class.java!!, "MkDatabase").build()
    }
}
