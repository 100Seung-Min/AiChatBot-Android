package com.example.aichatbot_android.ui.chat

import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.aichatbot_android.R
import com.example.aichatbot_android.databinding.FragmentChatBinding
import com.example.aichatbot_android.ui.base.BaseFragment

class ChatFragment : BaseFragment<FragmentChatBinding>(R.layout.fragment_chat) {
    override fun init() {
        binding.chatFragment = this
    }

    fun backBtn(view: View) {
        findNavController().popBackStack()
    }
}