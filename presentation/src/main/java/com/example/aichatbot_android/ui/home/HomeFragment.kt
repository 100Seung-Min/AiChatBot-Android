package com.example.aichatbot_android.ui.home

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.aichatbot_android.R
import com.example.aichatbot_android.databinding.FragmentHomeBinding
import com.example.aichatbot_android.util.ChatType
import com.example.aichatbot_android.ui.base.BaseFragment
import com.example.aichatbot_android.viewmodel.ChatViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val viewModel by activityViewModels<ChatViewModel>()

    override fun init() {
        binding.homeFragment = this
    }

    fun moveChat(view: View) {
        when(view.id) {
            R.id.LawChatBtn -> viewModel.setChatType(ChatType.LAW)
            R.id.WikiChatBtn -> viewModel.setChatType(ChatType.WIKI)
        }
        this.findNavController().navigate(R.id.action_homeFragment_to_chatFragment)
    }
}