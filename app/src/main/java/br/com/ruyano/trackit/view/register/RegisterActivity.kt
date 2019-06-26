package br.com.ruyano.trackit.view.register

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import br.com.ruyano.trackit.R
import br.com.ruyano.trackit.databinding.ActivityRegisterBinding
import br.com.ruyano.trackit.extensions.initToolbar

class RegisterActivity : AppCompatActivity() {

    private lateinit var mViewModel: RegisterViewModel
    private lateinit var mBinding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        mViewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        mBinding.viewModel = mViewModel
        mBinding.lifecycleOwner = this

        initToolbar(R.string.register, true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
