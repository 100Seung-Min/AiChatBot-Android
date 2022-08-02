package com.example.aichatbot_android.ui.extension

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

fun EditText.hide() {
    text.clear()
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun EditText.afterTextChanged(action: (p0: Editable?) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = kotlin.Unit

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = kotlin.Unit

        override fun afterTextChanged(p0: Editable?) {
            action(p0)
        }
    })
}