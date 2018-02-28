package com.mobiledev.popularmovies.di.scope

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

import javax.inject.Qualifier

/**
 * Created by manu on 2/27/2018.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
annotation class ActivityContext