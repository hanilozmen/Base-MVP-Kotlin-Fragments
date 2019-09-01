package com.trateg.basemvp.home

import com.trateg.basemvp.BasePresenter
import com.trateg.basemvp.BaseView

/**
 * Created by hanilozmen on 8/24/2019.
 */
interface HomeContract{
    interface Presenter: BasePresenter {
        fun onViewCreated()
        fun addFragment()
    }

    interface View: BaseView<Presenter> {
    }
}