package com.aceplus.kunyi.delegate

import com.aceplus.kunyi.data.vo.JobsVO

/**
 * Created by kkk on 8/2/2018.
 */
interface JobListDelegate {
    fun displayJobDetail(id: Int)
    fun displaySeekers(title: String, data: JobsVO)
}