package com.aceplus.kunyi.viewholder

import android.view.View
import com.aceplus.kunyi.data.vo.JobsVO
import com.aceplus.kunyi.delegate.JobListDelegate
import kotlinx.android.synthetic.main.job_listitem.view.*

/**
 * Created by kkk on 8/1/2018.
 */
class JobsViewHolder(itemView: View, private val delegate: JobListDelegate) : BaseViewHolder<JobsVO>(itemView), View.OnClickListener {
    private var data: JobsVO? = null
    override fun setData(data: JobsVO) {
        this.data = data

        itemView.jobShortDesp.text = data.shortDesc
        val amount = data.offerAmount!!.amount.toString() + " MMK"
        itemView.tvOfferAmount.text = amount
        val date = data.postedDate + " - " + data.postClosedDate
        itemView.tvPublishedDate.text = date

        val view = "Viewed " + data.viewed!!.size
        itemView.tvView.text = view

        val interest = "Interested " + data.interested!!.size
        itemView.tvInterest.text = interest

        val applicant = "Applicant " + data.applicant!!.size
        itemView.tvApplicant.text = applicant

        itemView.tvView.setOnClickListener { delegate.displaySeekers("Viewed", data) }
        itemView.tvInterest.setOnClickListener { delegate.displaySeekers("Interested", data) }
        itemView.tvApplicant.setOnClickListener { delegate.displaySeekers("Applied", data) }
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        delegate.displayJobDetail(data!!.jobPostId!!)
    }

}