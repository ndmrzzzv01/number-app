package com.example.numberapplication.view.adapters.binding

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("errorText")
fun TextInputLayout.errorText(error: String?) {
    this.error = error
}