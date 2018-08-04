package com.aceplus.kunyi.viewholder

import android.view.View
import com.aceplus.kunyi.data.vo.ApplicantVO
import com.aceplus.kunyi.delegate.JobDetailDelegate
import kotlinx.android.synthetic.main.list_item.view.*

/**
 * Created by kkk on 8/1/2018.
 */
class ApplicantViewHolder(itemView: View, private val delegate: JobDetailDelegate) : BaseViewHolder<ApplicantVO>(itemView), View.OnClickListener {
    private var data: ApplicantVO? = null
    override fun setData(data: ApplicantVO) {
        this.data = data
        itemView.listItemName.text = data.seekerName
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        delegate.displayApplicant(data!!.seekerId!!)
    }

}