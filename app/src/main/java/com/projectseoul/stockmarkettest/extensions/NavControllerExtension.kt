package com.projectseoul.stockmarkettest.extensions

import androidx.navigation.NavController

/**
 * Created by KING JINHO on 9/30/2021
 */
fun NavController.popBackStackAllInstances(destination: Int, inclusive: Boolean) : Boolean {

    var popped: Boolean
    while (true) {
        popped = popBackStack(destination, inclusive)
        if(!popped) {
            break
        }
    }
    return popped
}