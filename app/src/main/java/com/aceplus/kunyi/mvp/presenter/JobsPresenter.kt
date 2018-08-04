package com.aceplus.kunyi.mvp.presenter

import android.arch.lifecycle.LiveData
import com.aceplus.kunyi.data.model.KuNyiModel
import com.aceplus.kunyi.data.vo.JobsVO
import com.aceplus.kunyi.delegate.JobListDelegate
import com.aceplus.kunyi.mvp.view.JobsView

/**
 * Created by kkk on 8/2/2018.
 */
class JobsPresenter(view: JobsView) : BasePresenter<JobsView>(view), JobListDelegate {

    private val kuNyiModel: KuNyiModel = KuNyiModel.getInstance()

    init {
        loadData()
    }

    fun loadData() {
        kuNyiModel.loadJobsList()
    }

    fun getJobsList(): LiveData<List<JobsVO>> {
        return kuNyiModel.getJobsList()
    }

    override fun displayJobDetail(id: Int) {
        mView!!.displayJobsDetail(id)
    }

    override fun displaySeekers(title: String, data: JobsVO) {
        when (title) {
            "Viewed" -> {
                val seekerList = ArrayList<String>()
                data.viewed!!.mapTo(seekerList) { it.seekerName!! }
                mView!!.displaySeekers(title, seekerList)
            }
            "Interested" -> {
                val seekerList = ArrayList<String>()
                data.interested!!.mapTo(seekerList) { it.seekerName!! }
                mView!!.displaySeekers(title, seekerList)

            }
            "Applied" -> {
                val seekerList = ArrayList<String>()
                data.applicant!!.mapTo(seekerList) { it.seekerName!! }
                mView!!.displaySeekers(title, seekerList)
            }
        }
    }

}