package com.trateg.basemvp.main

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.trateg.basemvp.BaseActivity
import com.trateg.basemvp.R
import com.trateg.basemvp.home.HomePresenter
import com.trateg.basemvp.profile.ProfilePresenter
import com.trateg.basemvp.settings.SettingsPresenter
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by hanilozmen on 8/24/2019.
 */
class MainActivity : BaseActivity(), MainContract.View {

    private var mPresenter: MainContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        attachPresenter(MainPresenter(this))
        mPresenter?.onViewCreated(savedInstanceState != null)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mPresenter?.onSaveInstanceState(outState)

        // Static variables are dangerous :)
        outState.putInt("ProfilePresenter.mFragmentCount", ProfilePresenter.mFragmentCount)
        outState.putInt("HomePresenter.mFragmentCount", HomePresenter.mFragmentCount)
        outState.putInt("SettingsPresenter.mFragmentCount", SettingsPresenter.mFragmentCount)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        mPresenter?.onRestoreInstanceState(savedInstanceState)

        // Static variables are dangerous :)
        ProfilePresenter.mFragmentCount = savedInstanceState.getInt("ProfilePresenter.mFragmentCount")
        HomePresenter.mFragmentCount = savedInstanceState.getInt("HomePresenter.mFragmentCount")
        SettingsPresenter.mFragmentCount = savedInstanceState.getInt("SettingsPresenter.mFragmentCount")
    }

    override fun onDestroy() {
        detachPresenter()
        super.onDestroy()
    }

    override fun onBackPressed() {
        mPresenter?.onBackPressed()
    }

    override fun attachPresenter(presenter: MainContract.Presenter) {
        mPresenter = presenter
    }

    override fun detachPresenter() {
        mPresenter?.onDestroy()
        mPresenter = null
    }

    override fun finishActivity() {
        finish()
    }

    override fun getMainFragmentManager(): FragmentManager = supportFragmentManager

    override fun getFragmentHolderId(): Int = R.id.container_main

    override fun getBottomNavigation(): BottomNavigationView = view_navigation

    override fun showProgress() {}

    override fun hideProgress() {}


}
