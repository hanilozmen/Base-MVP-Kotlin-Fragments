package com.trateg.basemvp
/**
 * Created by hanilozmen on 8/24/2019.
 */
interface BaseView<T> {
    fun attachPresenter(presenter: T)
    fun detachPresenter()
    fun showProgress()
    fun hideProgress()
}