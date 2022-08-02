package com.example.aichatbot_android.ui.chat

import android.graphics.Color
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aichatbot_android.R
import com.example.aichatbot_android.adapter.ChatAdapter
import com.example.aichatbot_android.databinding.FragmentChatBinding
import com.example.aichatbot_android.ui.base.BaseFragment
import com.example.aichatbot_android.ui.extension.afterTextChanged
import com.example.aichatbot_android.ui.extension.hide
import com.example.aichatbot_android.util.ChatType
import com.example.aichatbot_android.viewmodel.ChatViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatFragment : BaseFragment<FragmentChatBinding>(R.layout.fragment_chat) {

    private val viewModel by activityViewModels<ChatViewModel>()
    private val chatList: ArrayList<String> = ArrayList()
    lateinit var chatAdapter: ChatAdapter

    override fun init() {
        binding.chatFragment = this
        binding.viewModel = viewModel
        initChatAdapter()
        textWriting()
    }

    private fun observeResult() = when (viewModel.chatType.value!!) {
        ChatType.WIKI -> viewModel.wikiResult.observe(this) {
            chatList.addAll(it.map { answerInfo -> answerInfo.answer })
            chatAdapter.notifyDataSetChanged()
        }
        ChatType.LAW -> viewModel.lawResult.observe(this) {
            chatList.addAll(it.map { answerInfo -> answerInfo.answer })
            chatAdapter.notifyDataSetChanged()
        }
    }

    fun sendBtn(view: View) = with(binding.userChatTxt) {
        if (text.toString().isNullOrEmpty()) {
            return shortToast("질문을 입력해주세요")
        }
        chatList.add(text.toString())
        when (viewModel.chatType.value) {
            ChatType.WIKI -> viewModel.wikiQA(text.toString())
            ChatType.LAW -> viewModel.lawQA(text.toString())
        }
        chatAdapter.notifyDataSetChanged()
        hide()
        observeResult()
    }

    private fun textWriting() = with(binding) {
        userChatTxt.afterTextChanged {
            sendBtn.setTextColor(Color.parseColor(if (it.toString()
                    .isNullOrEmpty()
            ) "#B4B4B4" else "#3182F7"))
        }
    }

    private fun initChatAdapter() {
        chatAdapter = ChatAdapter(chatList)
        with(binding.chatRecyclerView) {
            adapter = chatAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}