package com.aceplus.kunyi.adapter

import android.content.Context
import android.view.ViewGroup
import com.aceplus.kunyi.R
import com.aceplus.kunyi.data.vo.RelevantVO
import com.aceplus.kunyi.delegate.JobDetailDelegate
import com.aceplus.kunyi.viewholder.RelevantViewHolder

/**
 * Created by kkk on 8/1/2018.
 */
class RelevantAdapter(context: Context, private val delegate: JobDetailDelegate) : BaseRecyclerAdapter<RelevantVO>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RelevantViewHolder {
        val view = mLayoutInflater!!.inflate(R.layout.job_listitem, parent, false)
        return RelevantViewHolder(view, delegate)
    }
}