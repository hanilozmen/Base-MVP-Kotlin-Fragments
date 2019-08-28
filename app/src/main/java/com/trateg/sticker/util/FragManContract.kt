package com.trateg.sticker.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.trateg.sticker.BaseFragment
import java.io.Serializable

/**
 * Created by hanilozmen on 8/28/2019.
 */
abstract class FragManContract {
    // bottom navigation related
    abstract fun init(fragmentManager: FragmentManager, bottomNavigationView: BottomNavigationView, containerId: Int, isRestored: Boolean)
    abstract fun getCurrentTab(): Int
    abstract fun setCurrentTab(index: Int)
    abstract fun changeTab(index: Int, isBackPressChange: Boolean)
    abstract fun setBottomNavigationListener()
    abstract fun getMenuItemId(tabIndex: Int): Int

    // fragment manager related
    abstract fun addFragment(fragment: BaseFragment, tag: String? = null, inStack: Boolean? = true, addAndHide: Boolean? = false)
    abstract fun initRootFragments()
    abstract fun getHistory(): Array<ArrayList<String>>
    abstract fun setHistory(history: Serializable)
    abstract fun getActiveFragment(tabIndex: Int): Fragment?
    abstract fun onBackPressed(): Boolean
    abstract fun destroy()
}