package br.com.ruyano.trackit.extensions

import android.util.Patterns

fun String.isValidEmail() : Boolean = this.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()