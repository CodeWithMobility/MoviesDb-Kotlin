package com.mobiledev.popularmovies.ui.toprated

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobiledev.popularmovies.R
import com.mobiledev.popularmovies.data.model.TopRatedResponseModel
import com.mobiledev.popularmovies.ui.base.BaseFragment
import com.mobiledev.popularmovies.utils.CommonUtils
import com.mobiledev.popularmovies.utils.DialogConstants
import com.mobiledev.popularmovies.utils.DialogUtil
import io.reactivex.annotations.Nullable
import javax.inject.Inject

/**
 * Created by manu on 2/28/2018.
 */

class TopRatedFragment: BaseFragment(), TopRatedView, DialogUtil.OnDialogSelectedListener  {

    @Inject
    lateinit var mPresenter: TopRatedPresenter<TopRatedView>

    @Inject
    lateinit  var topRatedAdapter: TopRatedAdapter

    @Inject
    lateinit var mLayoutManager: LinearLayoutManager

    var recyclerView: RecyclerView? = null

    lateinit var rootView: View

    private var pastVisiblesItems: Int = 0

    var visibleItemCount: Int = 0

    private var loading = false

    private var page = 1

    var totalItemCount: Int = 0

    @Nullable
    override fun onCreateView(inflater: LayoutInflater?, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        rootView = inflater!!.inflate(R.layout.fragment_popular, container, false)

        val component = activityComponent
        if (component != null) {
            component.inject(this)
            mPresenter.onAttach(this)
        }
        recyclerView = rootView.findViewById(R.id.recyclerViewPopular)
        mLayoutManager?.orientation = LinearLayoutManager.VERTICAL
        recyclerView!!.layoutManager = mLayoutManager
        recyclerView!!.itemAnimator = DefaultItemAnimator()
        recyclerView!!.adapter = topRatedAdapter
        mPresenter.fetchAllTopRatedrMovies(page)

        recyclerView!!.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if (dy > 0){
                    visibleItemCount = mLayoutManager.childCount
                    totalItemCount = mLayoutManager.itemCount
                    pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition()
                    if (visibleItemCount + pastVisiblesItems >= totalItemCount) {
                            loading = true
                            page++
                        if(CommonUtils.isNetworkAvailable(context)) {
                            mPresenter.fetchAllTopRatedrMovies(page)
                        }
                    }
                }
            }
        })
        return rootView
    }
    override fun onError(message: String) {
        var dialogUtil = DialogUtil();
        dialogUtil.okFunc(activity, message, "Movies Db", this, DialogConstants.DIALOG_BUTTON_OK)
    }

    override fun onError(resId: Int) {
        var dialogUtil = DialogUtil();
        dialogUtil.okFunc(activity, getString(resId), "Movies Db", this, DialogConstants.DIALOG_BUTTON_OK)
    }


    override fun setUp(view: View?) {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mPresenter.onDetach()
    }

    override fun onGettingTopRatedMovieList(moviestResponseModel: TopRatedResponseModel) {
        topRatedAdapter?.addItems(moviestResponseModel.results)
    }

    override fun onDialogClick(selectedIndex: Int, mObj: Any?, dialogIndex: Int) {
        //Callback function based on dialog button click event
    }
}
