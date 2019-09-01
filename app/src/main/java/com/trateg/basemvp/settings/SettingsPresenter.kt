package com.trateg.basemvp.settings

import android.os.Bundle
import com.trateg.basemvp.BaseFragment
import com.trateg.basemvp.util.FragMan

/**
 * Created by hanilozmen on 8/24/2019.
 */
class SettingsPresenter(var mView: SettingsContract.View?) :
    SettingsContract.Presenter {

    companion object{
        const val KEY_TITLE: String = "KEY_TITLE"
        var mFragmentCount = 0
        fun newInstance(args: Bundle? = null): BaseFragment {
            val fragment = SettingsFragment()
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
        val instance =
            newInstance(Bundle().also {
                it.putString(
                    KEY_TITLE,
                    "Settings $mFragmentCount"
                )
            })
        FragMan.addFragment(instance)
    }

}