package com.aceplus.kunyi.mvp.presenter

import android.arch.lifecycle.LiveData
import com.aceplus.kunyi.data.model.KuNyiModel
import com.aceplus.kunyi.data.vo.JobsVO
import com.aceplus.kunyi.delegate.JobDetailDelegate
import com.aceplus.kunyi.mvp.view.JobDetailView

/**
 * Created by kkk on 8/2/2018.
 */
class JobDetailPresenter(view: JobDetailView) : BasePresenter<JobDetailView>(view), JobDetailDelegate {

    private val kuNyiModel: KuNyiModel = KuNyiModel.getInstance()

    fun getDataById(jobId: String?): LiveData<JobsVO> {
        return kuNyiModel.getDataById(jobId!!)
    }

    override fun displayApplicant(seekerId: Int) {
        mView!!.displayApplicantProfile(seekerId)
    }

}