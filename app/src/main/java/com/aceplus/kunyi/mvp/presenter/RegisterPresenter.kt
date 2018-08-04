package com.aceplus.kunyi.mvp.presenter

import android.arch.lifecycle.LiveData
import com.aceplus.kunyi.data.model.KuNyiModel
import com.aceplus.kunyi.data.vo.JobsVO
import com.aceplus.kunyi.mvp.view.RegisterView

/**
 * Created by kkk on 8/2/2018.
 */
class RegisterPresenter(view: RegisterView) : BasePresenter<RegisterView>(view) {

    private val kuNyiModel: KuNyiModel = KuNyiModel.getInstance()

    init {
        kuNyiModel.loadJobsList()
    }

    fun getJobsList(): LiveData<List<JobsVO>> {
        return kuNyiModel.getJobsList()
    }

}