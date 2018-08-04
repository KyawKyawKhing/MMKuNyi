package com.aceplus.kunyi.activity

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.aceplus.kunyi.R
import com.aceplus.kunyi.adapter.ListItemAdapter
import com.aceplus.kunyi.adapter.RelevantAdapter
import com.aceplus.kunyi.adapter.SkillAdapter
import com.aceplus.kunyi.data.vo.JobsVO
import com.aceplus.kunyi.mvp.presenter.JobDetailPresenter
import com.aceplus.kunyi.mvp.view.JobDetailView
import kotlinx.android.synthetic.main.activity_job_detail.*

class JobDetailActivity : BaseActivity(), JobDetailView {

    lateinit var mPresenter: JobDetailPresenter
    lateinit var mNoteAdapter: ListItemAdapter
    lateinit var mSkillAdapter: SkillAdapter
    lateinit var mRelevantAdapter: RelevantAdapter

    companion object {
        val IE_JOBID: String = "jobId"
        fun newIntent(context: Context, id: Int): Intent {
            val intent = Intent(context, JobDetailActivity::class.java)
            intent.putExtra(IE_JOBID, id)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_detail)
//        setSupportActionBar(toolbar)
//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        initUISetUp()
        val jobId = intent.getIntExtra(IE_JOBID, 1)
        mPresenter.getDataById(jobId.toString()).observe(this, Observer<JobsVO> { response ->
            if (response != null) {
                displayJobDetail(response)
            }
        })
    }

    private fun initUISetUp() {
        mPresenter = JobDetailPresenter(this)
        mNoteAdapter = ListItemAdapter(applicationContext)
        rvImportantNote.adapter = mNoteAdapter
        rvImportantNote.layoutManager = LinearLayoutManager(this)
        mSkillAdapter = SkillAdapter(applicationContext)
        rvSkill.adapter = mSkillAdapter
        rvSkill.layoutManager = LinearLayoutManager(this)
        mRelevantAdapter = RelevantAdapter(applicationContext, mPresenter)
        rvRelevant.adapter = mRelevantAdapter
        rvRelevant.layoutManager = LinearLayoutManager(this)
    }

    override fun displayJobDetail(job: JobsVO) {
        toolbar!!.title = job.shortDesc.toString()
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        fullDesp.text = job.fullDesc
        jobLocation.text = job.location
        val amount = job.offerAmount!!.amount.toString() + job.offerAmount!!.duration
        offerAmount.text = amount
        phone.text = job.phoneNo
        val data = job.postedDate + " - " + job.postClosedDate
        jobDate.text = data
//        mNoteAdapter.setNewList(job.importantNotes!!)
//        mRelevantAdapter.setNewList(job.relevant!!)
    }

    override fun displayApplicantProfile(seekerId: Int) {
        val intent = ApplicantProfileActivity.newIntent(applicationContext, IE_JOBID, seekerId)
        startActivity(intent)
    }


    override fun displayMessage(message: String) {

    }
}
