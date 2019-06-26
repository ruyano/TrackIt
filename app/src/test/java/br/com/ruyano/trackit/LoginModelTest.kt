package br.com.ruyano.trackit

import br.com.ruyano.trackit.view.login.LoginModel
import org.junit.Assert.assertEquals
import org.junit.Test
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Ignore
import org.junit.rules.TestRule
import org.junit.Rule



class LoginModelTest {

    private val mModel = LoginModel()

    private val INVALID_EMAIL = "ASDF"

    private val INVALID_PASSWORD = "123"
    private val VALID_PASSWORD = "123456"

    @Rule @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    @Ignore
    @Test
    fun isEmailValidTest() {
        // given
        mModel.email = INVALID_EMAIL

        // when
        val isEmailValid = mModel.isEmailValid()

        // then
        assertEquals(isEmailValid, false)
    }

    @Test
    fun `test with invalid password`() {
        // given
        mModel.password = INVALID_PASSWORD

        // when
        val isPasswordValid = mModel.isPasswordValid()

        // then
        assertEquals(isPasswordValid, false)
    }

    @Test
    fun `test with valid password`() {
        // given
        mModel.password = VALID_PASSWORD

        // when
        val isPasswordValid = mModel.isPasswordValid()

        // then
        assertEquals(isPasswordValid, true)
    }

}