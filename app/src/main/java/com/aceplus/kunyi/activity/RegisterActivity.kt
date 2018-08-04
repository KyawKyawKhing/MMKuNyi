package com.aceplus.kunyi.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.aceplus.kunyi.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, RegisterActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        tvLogin.setOnClickListener { goToLoginActivity() }
        btnGoogleRegister.setOnClickListener { makeGoogleRegister() }
    }


    private fun goToLoginActivity() {
        val intent = LoginActivity.newIntent(applicationContext)
        startActivity(intent)
        finish()
    }

    private fun makeGoogleRegister() {

    }

}
