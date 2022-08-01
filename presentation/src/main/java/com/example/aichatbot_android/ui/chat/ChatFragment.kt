package com.example.aichatbot_android.ui.chat

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.aichatbot_android.R
import com.example.aichatbot_android.databinding.FragmentChatBinding
import com.example.aichatbot_android.ui.base.BaseFragment
import com.example.aichatbot_android.viewmodel.ChatViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatFragment : BaseFragment<FragmentChatBinding>(R.layout.fragment_chat) {

    private val viewModel by activityViewModels<ChatViewModel>()

    override fun init() {
        binding.chatFragment = this
        binding.viewModel = viewModel
    }
}