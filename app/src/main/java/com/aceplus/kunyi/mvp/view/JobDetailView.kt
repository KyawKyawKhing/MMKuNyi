package com.aceplus.kunyi.mvp.view

import com.aceplus.kunyi.data.vo.JobsVO

/**
 * Created by kkk on 8/2/2018.
 */
interface JobDetailView : BaseView {
    fun displayJobDetail(job: JobsVO)

    fun displayApplicantProfile(seekerId: Int)
}