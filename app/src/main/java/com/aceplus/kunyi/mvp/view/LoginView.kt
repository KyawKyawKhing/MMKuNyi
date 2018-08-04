package com.aceplus.kunyi.mvp.view

import android.content.Intent

/**
 * Created by kkk on 8/2/2018.
 */
interface LoginView : BaseView {
    fun displayProgressBar(visible:Int)
    fun displayJobList()
    fun startActivityForResult(intent: Intent, resultCode: Int)
}