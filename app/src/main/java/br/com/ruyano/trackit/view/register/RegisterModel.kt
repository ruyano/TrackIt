package br.com.ruyano.trackit.view.register

import androidx.lifecycle.MutableLiveData
import br.com.ruyano.trackit.R
import br.com.ruyano.trackit.extensions.isValidEmail

class RegisterModel(var name: String = "",
                    var email: String = "",
                    var password: String = "",
                    var nameError: MutableLiveData<Int> = MutableLiveData(),
                    var emailError: MutableLiveData<Int> = MutableLiveData(),
                    var passwordError: MutableLiveData<Int> = MutableLiveData()) {

    fun isValid(): Boolean {
        val isNameValid = isNameValid()
        val isEmailValid = isEmailValid()
        val isPasswordValid = isPasswordValid()
        return isNameValid && isEmailValid && isPasswordValid
    }

    fun isNameValid(): Boolean =
        if (!name.isEmpty()) {
            nameError.value = null
            true
        } else {
            nameError.value = R.string.error_invalid_name
            false
        }

    fun isEmailValid(): Boolean =
        if (email.isValidEmail()) {
            emailError.value = null
            true
        } else {
            emailError.value = R.string.error_invalid_email
            false
        }

    private fun isPasswordValid(): Boolean =
        if (password.length > 5) {
            passwordError.value = null
            true
        } else {
            passwordError.value = R.string.error_short_password
            false
        }
}