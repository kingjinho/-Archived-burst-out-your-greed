package com.projectseoul.stockmarkettest.screens

import android.os.Bundle
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.projectseoul.stockmarkettest.extensions.popBackStackAllInstances

/**
 * Created by KING JINHO on 9/30/2021
 */
open class BaseBottomFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        addCallback()
        super.onCreate(savedInstanceState)
    }

    private fun addCallback() {
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            val navController = findNavController()
            if(navController.currentBackStackEntry?.destination?.id != null) {
                navController.popBackStackAllInstances(
                    navController.currentBackStackEntry?.destination?.id!!, true
                )
            }

            if(navController.currentBackStackEntry?.destination?.id == null) {
                requireActivity().finish()
            }
        }
    }
}