package com.mobiledev.popularmovies.di.scope

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

import javax.inject.Scope

/**
 * Created by manu on 2/27/2018.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class PerActivity