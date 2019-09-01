package com.trateg.basemvp.home

import android.os.Bundle
import com.trateg.basemvp.BaseFragment
import com.trateg.basemvp.util.FragMan

/**
 * Created by hanilozmen on 8/24/2019.
 */
class HomePresenter(var mView: HomeContract.View?) :
    HomeContract.Presenter {

    companion object{
        const val KEY_TITLE: String = "KEY_TITLE"
        var mFragmentCount = 0
        fun newInstance(args: Bundle? = null): BaseFragment {
            val fragment = HomeFragment()
            args?.let { fragment.arguments = it }
            return fragment
        }
    }

    override fun onViewCreated() {
    }

    override fun onDestroy() {
        mView = null
        mFragmentCount--
    }

    override fun addFragment() {
        mFragmentCount++
        val instance = newInstance(Bundle().also {
            it.putString(
                KEY_TITLE,
                "Home $mFragmentCount"
            )
        })
        FragMan.addFragment(instance)
    }

}