package br.com.ruyano.trackit.view.login

import androidx.lifecycle.MutableLiveData
import br.com.ruyano.trackit.R
import br.com.ruyano.trackit.extensions.isValidEmail

class LoginModel(var email: String = "",
                 var password: String = "",
                 var emailError: MutableLiveData<Int> = MutableLiveData(),
                 var passwordError: MutableLiveData<Int> = MutableLiveData()) {

    fun isValid(): Boolean {
        val isEmailValid = isEmailValid()
        val isPasswordValid = isPasswordValid()
        return isEmailValid && isPasswordValid
    }

    fun isEmailValid(): Boolean =
        if (email.isValidEmail()) {
            emailError.value = null
            true
        } else {
            emailError.value = R.string.error_invalid_email
            false
        }

    fun isPasswordValid(): Boolean =
        if (password.length > 5) {
            passwordError.value = null
            true
        } else {
            passwordError.value = R.string.error_invalid_password
            false
        }
}