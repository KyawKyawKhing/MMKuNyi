package com.aceplus.kunyi.data.model

import android.arch.lifecycle.LiveData
import android.content.Context
import com.aceplus.kunyi.data.vo.JobsVO
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.*

/**
 * Created by kkk on 8/1/2018.
 */
open class KuNyiModel private constructor(context: Context) : BaseModel(context) {

    private val mDatabaseReference: DatabaseReference = FirebaseDatabase.getInstance().reference

    private val mFirebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val mFirebaseUser: FirebaseUser?

    val isUserSignIn: Boolean
        get() = mFirebaseUser != null

    init {
        mFirebaseUser = mFirebaseAuth.currentUser
    }

    companion object {

        private var INSTANCE: KuNyiModel? = null

        fun getInstance(): KuNyiModel {
            if (INSTANCE == null) {
                throw RuntimeException("KuNyiModel is being invoked before initializing.")
            }
            val i = INSTANCE
            return i!!
        }

        fun initKuNyiModel(context: Context) {
            INSTANCE = KuNyiModel(context)
        }
    }

    fun loadJobsList() {
        mDatabaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot?) {
                if (dataSnapshot != null) {
                    val jobsList = dataSnapshot.children
                            .map { it.getValue<JobsVO>(JobsVO::class.java) }
                            .map { it!! }
                    saveIntoDB(jobsList)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }

    fun authenticateUserWithGoogleAccount(signInAccount: GoogleSignInAccount,
                                          delegate: SignInWithGoogleAccountDelegate) {
        val credential = GoogleAuthProvider.getCredential(signInAccount.idToken, null)
        mFirebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        delegate.onFailureSignIn(task.exception!!.message!!)
                    } else {
                        delegate.onSuccessSignIn(signInAccount)
                    }
                }
                .addOnFailureListener { e ->
                    delegate.onFailureSignIn(e.message!!)
                }
    }

    private fun saveIntoDB(jobsList: List<JobsVO>) {
        mAppDatabase.jobsDao().insertAll(jobsList)
    }

    fun getJobsList(): LiveData<List<JobsVO>> {
        return mAppDatabase.jobsDao().getAllData()
    }

    fun getDataById(id: String): LiveData<JobsVO> {
        return mAppDatabase.jobsDao().getDataById(id)
    }

    interface SignInWithGoogleAccountDelegate {
        fun onSuccessSignIn(signInAccount: GoogleSignInAccount)

        fun onFailureSignIn(msg: String)
    }


}