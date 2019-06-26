package br.com.ruyano.trackit.view.register

import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {

    val mModel = RegisterModel()

    fun createAccount() {
        if (mModel.isValid()) {
            // TODO - perform create account
        }
    }

}