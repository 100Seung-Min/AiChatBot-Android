package com.example.aichatbot_android.ui.chat

import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.widget.addTextChangedListener
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
        textWriting()
    }

    private fun textWriting() = with(binding){
        userChatTxt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
            override fun afterTextChanged(p0: Editable?) {
                sendBtn.setTextColor(Color.parseColor(if(p0.toString().isNullOrEmpty()) "#B4B4B4" else "#3182F7"))
            }
        })
    }
}