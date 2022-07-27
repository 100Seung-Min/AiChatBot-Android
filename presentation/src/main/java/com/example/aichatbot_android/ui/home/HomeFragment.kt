package com.example.aichatbot_android.ui.home

import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.aichatbot_android.R
import com.example.aichatbot_android.databinding.FragmentHomeBinding
import com.example.aichatbot_android.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override fun init() {
        binding.homeFragment = this
    }

    fun moveChat(view: View) {
        this.findNavController().navigate(R.id.action_homeFragment_to_chatFragment)
    }
}