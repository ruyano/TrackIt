package br.com.ruyano.trackit.util

import androidx.databinding.BindingAdapter
import br.com.ruyano.trackit.extensions.onTextChanged
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("error")
fun TextInputLayout.setError(strOrResId: Any?) {
    editText?.onTextChanged {
        error = null
        isErrorEnabled = false
    }
    if (strOrResId == null) {
        return
    }
    error = if (strOrResId is Int) {
        context.getString(strOrResId)
    } else {
        strOrResId as String
    }
    isErrorEnabled = true
}