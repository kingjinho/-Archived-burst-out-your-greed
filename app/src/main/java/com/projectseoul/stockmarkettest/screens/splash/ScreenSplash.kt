package com.projectseoul.stockmarkettest.screens.splash

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.projectseoul.stockmarkettest.R
import com.projectseoul.stockmarkettest.databinding.FragmentSplashBinding
import com.projectseoul.stockmarkettest.viewmodels.FragmentSplashViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import java.util.concurrent.TimeUnit

/**
 * Created by KING JINHO on 9/14/2021
 */
class ScreenSplash : Fragment() {

    private lateinit var binding: FragmentSplashBinding
    private val viewModel by lazy {
        ViewModelProvider(this).get(FragmentSplashViewModel::class.java)
    }
    private var job: Job? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onStop() {
        super.onStop()
        job?.cancel()
    }

    override fun onResume() {
        super.onResume()
        getBasicInformation()
    }

    private fun getBasicInformation() {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        val lastUpdate = sharedPref?.getLong(getString(R.string.shared_pref_last_update), 0)
        if (lastUpdate == null || TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - lastUpdate) > 0) {
            job = viewLifecycleOwner.lifecycleScope.launchWhenResumed {
                viewModel.refreshData().collectLatest {
                    if (it) {
                        with(sharedPref?.edit()) {
                            this?.apply {
                                putLong(
                                    getString(R.string.shared_pref_last_update),
                                    System.currentTimeMillis()
                                )
                            }
                        }
                        findNavController().navigate(R.id.splash_to_main)
                    } else {
                        Toast.makeText(requireContext(), R.string.msg_error, Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }
    }
}