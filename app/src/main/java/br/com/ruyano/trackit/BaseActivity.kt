package br.com.ruyano.trackit

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    private val progressBar  = ProgressBar(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected fun showLoading() {

    }

    protected fun hideLoading() {

    }

}