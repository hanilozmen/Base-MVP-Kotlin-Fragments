package com.trateg.basemvp.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.trateg.basemvp.BaseFragment
import com.trateg.basemvp.R
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * Created by hanilozmen on 8/24/2019.
 */
class ProfileFragment: BaseFragment(),
    ProfileContract.View {
    private lateinit var mRootView : View
    private var mPresenter: ProfileContract.Presenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRootView = inflater.inflate(R.layout.fragment_profile, container, false)
        attachPresenter(ProfilePresenter(this))
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arg = arguments?.getString(ProfilePresenter.KEY_TITLE,"")
        text_title.text = arg
        if(arg?.contains("Root") != true) {
            mRootView.setBackgroundColor(ContextCompat.getColor(mRootView.context, R.color.colorPrimaryDark))
        }
        button_add_fragment.setOnClickListener { mPresenter?.addFragment() }
    }

    override fun onDestroyView() {
        detachPresenter()
        super.onDestroyView()
    }

    override fun attachPresenter(presenter: ProfileContract.Presenter) {
        mPresenter = presenter
    }

    override fun detachPresenter() {
        mPresenter?.onDestroy()
        mPresenter = null
    }

    override fun showProgress() {
    }

    override fun hideProgress() {
    }

}