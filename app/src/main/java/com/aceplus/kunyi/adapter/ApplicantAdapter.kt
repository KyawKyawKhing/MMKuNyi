package com.aceplus.kunyi.adapter

import android.content.Context
import android.view.ViewGroup
import com.aceplus.kunyi.R
import com.aceplus.kunyi.data.vo.ApplicantVO
import com.aceplus.kunyi.delegate.JobDetailDelegate
import com.aceplus.kunyi.viewholder.ApplicantViewHolder

/**
 * Created by kkk on 8/1/2018.
 */
class ApplicantAdapter(context: Context, private val delegate: JobDetailDelegate) : BaseRecyclerAdapter<ApplicantVO>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApplicantViewHolder {
        val view = mLayoutInflater!!.inflate(R.layout.job_listitem, parent, false)
        return ApplicantViewHolder(view, delegate)
    }
}