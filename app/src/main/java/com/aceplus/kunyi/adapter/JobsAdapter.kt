package com.aceplus.kunyi.adapter

import android.content.Context
import android.view.ViewGroup
import com.aceplus.kunyi.R
import com.aceplus.kunyi.data.vo.JobsVO
import com.aceplus.kunyi.delegate.JobListDelegate
import com.aceplus.kunyi.viewholder.JobsViewHolder

/**
 * Created by kkk on 8/1/2018.
 */
class JobsAdapter(context: Context, private val delegate: JobListDelegate) : BaseRecyclerAdapter<JobsVO>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobsViewHolder {
        val view = mLayoutInflater!!.inflate(R.layout.job_listitem, parent, false)
        return JobsViewHolder(view, delegate)
    }
}