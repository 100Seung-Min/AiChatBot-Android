package com.example.aichatbot_android.ui.chat

import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import com.example.aichatbot_android.R
import com.example.aichatbot_android.databinding.FragmentChatBinding
import com.example.aichatbot_android.ui.base.BaseFragment
import com.example.aichatbot_android.ui.extension.afterTextChanged
import com.example.aichatbot_android.ui.extension.hide
import com.example.aichatbot_android.viewmodel.ChatViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatFragment : BaseFragment<FragmentChatBinding>(R.layout.fragment_chat) {

    private val viewModel by activityViewModels<ChatViewModel>()

    override fun init() {
        binding.chatFragment = this
        binding.viewModel = viewModel
        textWriting()
        observeResult()
    }

    private fun observeResult() = when(viewModel.chatType.value) {
        "위키박사" -> viewModel.wikiResult.observe(this) {
        }
        "법률박사" -> viewModel.lawResult.observe(this) {
        }
        else -> Unit
    }

    fun sendBtn(view: View) = with(binding.userChatTxt) {
        if (text.toString().isNullOrEmpty()) {
            return shortToast("질문을 입력해주세요")
        }
        when (viewModel.chatType.value) {
            "위키박사" -> viewModel.wikiQA(text.toString())
            "법률박사" -> viewModel.lawQA(text.toString())
        }
        text.clear()
        hide()
    }

    private fun textWriting() = with(binding) {
        userChatTxt.afterTextChanged {
            sendBtn.setTextColor(Color.parseColor(if (it.toString().isNullOrEmpty()) "#B4B4B4" else "#3182F7"))
        }
    }
}