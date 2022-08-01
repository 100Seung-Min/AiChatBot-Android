package com.example.aichatbot_android.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.param.LawParam
import com.example.domain.param.WikiParam
import com.example.domain.usecase.LawQAUseCase
import com.example.domain.usecase.WikiQAUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val wikiQAUseCase: WikiQAUseCase,
    private val lawQAUseCase: LawQAUseCase
): ViewModel() {

    private val ACCESS_KEY = "24049d6a-b054-4a8d-909d-af913c5e2bba"

    private val _chatType = MutableLiveData<String>()
    val chatType: LiveData<String> get() = _chatType

    fun setChatType(type: String) {
        _chatType.value = type
    }

    fun wikiQA(question: String) {
        try {
            viewModelScope.launch {
                val response = wikiQAUseCase.execute(wikiParam = WikiParam(
                    access_key = ACCESS_KEY,
                    argument = WikiParam.Argument(
                        question = question,
                        type = "hybridqa"
                    )
                ))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun lawQA(question: String) {
        try {
            viewModelScope.launch {
                val response = lawQAUseCase.execute(lawParam = LawParam(
                    access_key = ACCESS_KEY,
                    argument = LawParam.Argument(
                        question = question,
                    )
                ))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}