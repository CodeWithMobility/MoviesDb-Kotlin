package com.mobiledev.popularmovies.ui.landing

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.mobiledev.popularmovies.R
import com.mobiledev.popularmovies.ui.base.BaseActivity
import com.mobiledev.popularmovies.ui.nowplaying.NowPlayingFragment
import com.mobiledev.popularmovies.ui.popular.PopularFragment
import com.mobiledev.popularmovies.ui.toprated.TopRatedFragment
import com.mobiledev.popularmovies.ui.upcoming.UpComingFragment
import com.mobiledev.popularmovies.widgets.SuperDrawerLayout
import javax.inject.Inject

class LandingActivity : BaseActivity() ,LandingView , NavigationView.OnNavigationItemSelectedListener{

    @Inject
    lateinit var mPresenter: LandingPresenter<LandingView>

    private var drawer: SuperDrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        activityComponent!!.inject(this)
        mPresenter.onAttach(this)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawer = findViewById(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer)
        drawer!!.addDrawerListener(toggle)
        toggle.syncState()
        drawer!!.customAdjustment(10.0f, 0.8f, 10.0f, 10f)
        val mNavigationView = findViewById<NavigationView>(R.id.navigation_view)
        mNavigationView.setNavigationItemSelectedListener(this)


        supportFragmentManager.beginTransaction().replace(R.id.containerView, PopularFragment()).commit()
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_item_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.containerView, PopularFragment()).commit()
            }
            R.id.nav_item_about -> {
                supportFragmentManager.beginTransaction().replace(R.id.containerView, TopRatedFragment()).commit()
            }
            R.id.nav_item_settings -> {
                supportFragmentManager.beginTransaction().replace(R.id.containerView, UpComingFragment()).commit()
            }
            R.id.nav_item_logout -> {
                supportFragmentManager.beginTransaction().replace(R.id.containerView, NowPlayingFragment()).commit()
            }

        }
        drawer!!.closeDrawer(GravityCompat.START)
        return true
    }
}
