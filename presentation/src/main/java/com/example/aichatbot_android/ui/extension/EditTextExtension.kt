package com.example.aichatbot_android.ui.extension

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

fun EditText.hide() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}