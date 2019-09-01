package com.trateg.basemvp.settings

import com.trateg.basemvp.BasePresenter
import com.trateg.basemvp.BaseView

/**
 * Created by hanilozmen on 8/24/2019.
 */
interface SettingsContract{
    interface Presenter: BasePresenter {
        fun onViewCreated()
        fun addFragment()
    }

    interface View:
        BaseView<Presenter> {
    }
}