package com.trateg.sticker.main

import android.os.Bundle
import com.trateg.sticker.util.FragMan

/**
 * Created by hanilozmen on 8/24/2019.
 */
class MainPresenter(private var mView: MainContract.View?): MainContract.Presenter {

    override fun onBackPressed() {
        mView?.let {
            if(FragMan.onBackPressed()) {
                it.finishActivity()
            }
        }
    }

    override fun onViewCreated(isRestored: Boolean) {
        mView?.let {
            FragMan.init(it.getMainFragmentManager(), it.getBottomNavigation(), it.getFragmentHolderId(), isRestored)
        }

    }

    override fun onDestroy() {
        mView = null
        FragMan.destroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putSerializable(FragMan.HISTORY_KEY, FragMan.getHistory())
        outState.putInt(FragMan.CURRENT_TAB_KEY, FragMan.getCurrentTab())
    }

    override fun onRestoreInstanceState(savedState: Bundle) {
        savedState.getSerializable(FragMan.HISTORY_KEY)?.let { FragMan.setHistory(it)  }
        savedState.getInt(FragMan.CURRENT_TAB_KEY)?.let { FragMan.setCurrentTab(it) }
    }

}