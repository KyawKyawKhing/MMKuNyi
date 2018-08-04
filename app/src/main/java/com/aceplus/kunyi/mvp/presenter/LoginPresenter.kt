package com.aceplus.kunyi.mvp.presenter

import android.content.Intent
import android.view.View
import com.aceplus.kunyi.data.model.KuNyiModel
import com.aceplus.kunyi.mvp.view.LoginView
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.common.api.GoogleApiClient

/**
 * Created by kkk on 8/2/2018.
 */
class LoginPresenter(view: LoginView) : BasePresenter<LoginView>(view) {
    fun makeSignIn(mGoogleApiClient: GoogleApiClient, rC_GOOGLE_SIGN_IN: Int) {
        mView!!.displayProgressBar(View.VISIBLE)
        if (KuNyiModel.getInstance().isUserSignIn) {
            mView!!.displayProgressBar(View.GONE)
            mView!!.displayJobList()
        } else {
            val signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient)
            mView!!.startActivityForResult(signInIntent, rC_GOOGLE_SIGN_IN)

        }
    }

    fun onActivityResult(data: Intent?) {
        mView!!.displayProgressBar(View.VISIBLE)
        val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
        processGoogleSignInResult(result)
    }

    private fun processGoogleSignInResult(signInResult: GoogleSignInResult) {
        if (signInResult.isSuccess) {
            val account = signInResult.signInAccount
            KuNyiModel.getInstance().authenticateUserWithGoogleAccount(account!!, object : KuNyiModel.SignInWithGoogleAccountDelegate {
                override fun onSuccessSignIn(signInAccount: GoogleSignInAccount) {
                    mView!!.displayProgressBar(View.GONE)
                    mView!!.displayJobList()
                }

                override fun onFailureSignIn(msg: String) {
                    mView!!.displayProgressBar(View.GONE)
                    mView!!.displayMessage(msg)
                }

            })
        } else {
            mView!!.displayProgressBar(View.GONE)
            mView!!.displayMessage("Your Google sign-in failed.")
        }
    }

}