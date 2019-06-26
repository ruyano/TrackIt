package br.com.ruyano.trackit.extensions

import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.initToolbar(titleResId: Int, backEnabled: Boolean) {
    supportActionBar?.run {
        setTitle(titleResId)
        setDisplayHomeAsUpEnabled(backEnabled)
    }
}