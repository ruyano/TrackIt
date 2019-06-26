package br.com.ruyano.trackit.view.login

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var mModel = LoginModel()

    fun doLogin() {
        if (mModel.isValid()) {
            // TODO - perform login
        }
    }

}