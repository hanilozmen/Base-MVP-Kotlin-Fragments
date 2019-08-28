package com.trateg.sticker.settings

import com.trateg.sticker.BasePresenter
import com.trateg.sticker.BaseView

/**
 * Created by hanilozmen on 8/24/2019.
 */
interface SettingsContract{
    interface Presenter: BasePresenter {
        fun onViewCreated()
        fun addFragment()
    }

    interface View: BaseView<Presenter>{
    }
}