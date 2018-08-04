package com.aceplus.kunyi

import android.app.Application
import com.aceplus.kunyi.data.model.KuNyiModel

/**
 * Created by kkk on 8/2/2018.
 */
class KuNyiApp : Application() {
    override fun onCreate() {
        super.onCreate()
        KuNyiModel.initKuNyiModel(applicationContext)
    }
}