package com.trateg.basemvp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
/**
 * Created by hanilozmen on 8/24/2019.
 */
abstract class BaseFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        savedInstanceState?.let {
            Log.i("ANIL", it.toString())
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}