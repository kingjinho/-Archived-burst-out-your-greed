package com.projectseoul.stockmarkettest.screens.splash

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.projectseoul.stockmarkettest.R
import com.projectseoul.stockmarkettest.databinding.FragmentSplashBinding
import com.projectseoul.stockmarkettest.screens.ActivityMain
import com.projectseoul.stockmarkettest.viewmodels.FragmentSplashViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by KING JINHO on 9/14/2021
 */
class ScreenSplash : Fragment() {

    @Inject
    lateinit var viewModel: FragmentSplashViewModel
    private lateinit var binding: FragmentSplashBinding

    private var job: Job? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as ActivityMain).injector.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getBasicInformation()
    }

    override fun onStop() {
        super.onStop()
        job?.cancel()
    }

    private fun getBasicInformation() {
        viewLifecycleOwner.lifecycleScope.launch {
            if (!viewModel.shouldInvalidateLocalDatabase()) {
                findNavController().navigate(R.id.splash_to_main)
                return@launch
            } else {
                viewModel.refreshData().collectLatest {
                    if (it) {
                        viewModel.updateLastUpdateDateInMilliSeconds()
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