package com.example.aichatbot_android.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.param.WikiParam
import com.example.domain.usecase.WikiQAUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val wikiQAUseCase: WikiQAUseCase
): ViewModel() {

    private val _chatType = MutableLiveData<String>()
    val chatType: LiveData<String> get() = _chatType

    fun setChatType(type: String) {
        _chatType.value = type
    }
}