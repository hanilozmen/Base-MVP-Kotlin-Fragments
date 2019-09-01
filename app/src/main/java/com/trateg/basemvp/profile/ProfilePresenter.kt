package com.trateg.basemvp.profile

import android.os.Bundle
import com.trateg.basemvp.BaseFragment
import com.trateg.basemvp.util.FragMan

/**
 * Created by hanilozmen on 8/24/2019.
 */
class ProfilePresenter(var mView: ProfileContract.View?):
    ProfileContract.Presenter {
    companion object {
        const val KEY_TITLE: String = "KEY_TITLE"
        var mFragmentCount = 0
        fun newInstance(args: Bundle? = null): BaseFragment {
            val fragment = ProfileFragment()
            args?.let {  fragment.arguments = it }
            return fragment
        }
    }

    override fun onDestroy() {
        mView = null
        mFragmentCount--
    }


    override fun onViewCreated() {
        // TODO do network calls, db operations etc.
    }

    override fun addFragment() {
        mFragmentCount++
        val ınstance =
            newInstance(Bundle().also {
                it.putString(
                    KEY_TITLE,
                    "Profile $mFragmentCount"
                )
            })
        FragMan.addFragment(ınstance)
    }

}