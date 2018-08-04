package com.aceplus.kunyi.mvp.view

import com.aceplus.kunyi.data.vo.JobsVO

/**
 * Created by kkk on 8/2/2018.
 */
interface RegisterView : BaseView {
    fun displayJobsList(jobs: List<JobsVO>)
    fun displayJobsDetail(id: Int)
}