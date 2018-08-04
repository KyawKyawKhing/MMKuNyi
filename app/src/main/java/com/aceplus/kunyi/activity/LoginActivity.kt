package com.aceplus.kunyi.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.aceplus.kunyi.R
import com.aceplus.kunyi.mvp.presenter.LoginPresenter
import com.aceplus.kunyi.mvp.view.LoginView
import com.google.android.gms.appinvite.AppInvite
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView, GoogleApiClient.OnConnectionFailedListener {

    private lateinit var mPresenter: LoginPresenter
    private lateinit var mGoogleApiClient: GoogleApiClient
    private val RC_GOOGLE_SIGN_IN = 10

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, LoginActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mPresenter = LoginPresenter(this)

        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("567606042881-rhekgcjq68u6crjvmnnhvad8uk7jnjqf.apps.googleusercontent.com")
                .requestEmail()
                .build()

        mGoogleApiClient = GoogleApiClient.Builder(applicationContext)
                .enableAutoManage(this /*FragmentActivity*/, this /*OnConnectionFailedListener*/)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .addApi(AppInvite.API)
                .build()

        btnSignIn.setOnClickListener {
            displayJobList()
        }
        btnGoogleSignIn.setOnClickListener {
            mPresenter.makeSignIn(mGoogleApiClient, RC_GOOGLE_SIGN_IN)
        }
        tvCreateAccount.setOnClickListener { goToRegisterActivity() }
    }

    private fun goToRegisterActivity() {
        val intent = RegisterActivity.newIntent(applicationContext)
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_GOOGLE_SIGN_IN) run {
            mPresenter.onActivityResult(data)
        }
    }

    override fun displayJobList() {
        val intent = MainActivity.newIntent(this)
        startActivity(intent)
        finish()
    }

    override fun displayMessage(message: String) {
        Snackbar.make(clLogin, message, Snackbar.LENGTH_LONG).show()
    }

    override fun displayProgressBar(visible: Int) {
        progressBar.visibility = visible
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
