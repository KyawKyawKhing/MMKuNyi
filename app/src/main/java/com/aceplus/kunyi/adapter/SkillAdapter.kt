package com.aceplus.kunyi.adapter

import android.content.Context
import android.view.ViewGroup
import com.aceplus.kunyi.R
import com.aceplus.kunyi.data.vo.RequiredSkillVO
import com.aceplus.kunyi.delegate.JobDetailDelegate
import com.aceplus.kunyi.viewholder.SkillViewHolder

/**
 * Created by kkk on 8/1/2018.
 */
class SkillAdapter(context: Context) : BaseRecyclerAdapter<RequiredSkillVO>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        val view = mLayoutInflater!!.inflate(R.layout.job_listitem, parent, false)
        return SkillViewHolder(view)
    }
}