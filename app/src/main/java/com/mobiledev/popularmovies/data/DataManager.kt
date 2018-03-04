package com.mobiledev.popularmovies.data

import com.mobiledev.popularmovies.data.local.IDBHelper
import com.mobiledev.popularmovies.data.network.IApiHelper

/**
 * Created by manu on 2/27/2018.
 */

interface DataManager : IApiHelper, IDBHelper
