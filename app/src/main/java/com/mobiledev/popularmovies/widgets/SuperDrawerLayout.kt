package com.mobiledev.popularmovies.widgets

/**
 * Created by manu on 2/27/2018.
 */

import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.CardView
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout

/**
 * Created by manu on 2/25/2018.
 */

class SuperDrawerLayout : DrawerLayout {

    private var frameLayout: FrameLayout? = null
    var drawerView: View? = null
    internal lateinit var cardView: CardView
    val scrimColor = Color.TRANSPARENT
    internal  var elevation = 0.0f
    var scalefactor = 0.8f
    private var adjustfactor = 10.0f
    private var radius = 0.0f

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(context)
    }

    private fun init(context: Context) {
        addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                this@SuperDrawerLayout.drawerView = drawerView
                updateSlideOffset(drawerView, slideOffset)
            }

            override fun onDrawerOpened(drawerView: View) {}

            override fun onDrawerClosed(drawerView: View) {}

            override fun onDrawerStateChanged(newState: Int) {}
        })
        frameLayout = FrameLayout(context)
        super.addView(frameLayout)
    }


    override fun addView(child: View, params: ViewGroup.LayoutParams) {
        child.layoutParams = params
        addView(child)
    }

    override fun addView(child: View) {
        if (child is NavigationView) {
            super.addView(child)
        } else {
            cardView = CardView(context)
            cardView.radius = 0f
            cardView.addView(child)
            cardView.cardElevation = 0f
            frameLayout!!.addView(cardView)
        }
    }


    override fun openDrawer(drawerView: View, animate: Boolean) {
        super.openDrawer(drawerView, animate)
        post { updateSlideOffset(drawerView, if (isDrawerOpen(drawerView)) 1f else 0f) }
    }


    fun customAdjustment(radius: Float, scalefactor: Float, adjustfactor: Float, elevation: Float) {
        this.radius = radius
        this.scalefactor = scalefactor
        this.adjustfactor = adjustfactor
        this.elevation = elevation
    }

    private fun updateSlideOffset(drawerView: View, slideOffset: Float) {
        val absHorizGravity = getDrawerViewAbsoluteGravity(Gravity.START)
        val childAbsGravity = getDrawerViewAbsoluteGravity(drawerView)
        cardView.radius = (radius * slideOffset).toInt().toFloat()
        super.setScrimColor(scrimColor)
        super.setDrawerElevation(2f)
        val percentage = 1f - scalefactor
        val reduceHeight = height.toFloat() * percentage * slideOffset
        val params = cardView.layoutParams as FrameLayout.LayoutParams
        params.topMargin = (reduceHeight / 2).toInt()
        params.bottomMargin = (reduceHeight / 2).toInt()
        cardView.layoutParams = params
        cardView.cardElevation = elevation * slideOffset
        val width = if (childAbsGravity == absHorizGravity)
            drawerView.width + adjustfactor
        else
            -drawerView.width - adjustfactor
        cardView.x = width * slideOffset
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (drawerView != null)
            updateSlideOffset(drawerView!!, if (isDrawerOpen(drawerView!!)) 1f else 0f)
    }

    internal fun getDrawerViewAbsoluteGravity(gravity: Int): Int {
        return GravityCompat.getAbsoluteGravity(gravity, ViewCompat.getLayoutDirection(this)) and Gravity.HORIZONTAL_GRAVITY_MASK
    }

    internal fun getDrawerViewAbsoluteGravity(drawerView: View): Int {
        val gravity = (drawerView.layoutParams as DrawerLayout.LayoutParams).gravity
        return getDrawerViewAbsoluteGravity(gravity)
    }
}