package com.projectseoul.stockmarkettest.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.projectseoul.stockmarkettest.R

/**
 * Created by KING JINHO on 9/14/2021
 */
class FragmentSearch : BaseBottomFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

}