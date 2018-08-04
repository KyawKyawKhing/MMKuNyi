package com.aceplus.kunyi.activity

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.aceplus.kunyi.R
import com.aceplus.kunyi.adapter.ListItemAdapter
import com.aceplus.kunyi.mvp.presenter.ApplicantPresenter
import com.aceplus.kunyi.mvp.view.ApplicantView
import kotlinx.android.synthetic.main.activity_applicant_profile.*

class ApplicantProfileActivity : AppCompatActivity(), ApplicantView {

    lateinit var mPresenter: ApplicantPresenter
    lateinit var mSkillsAdapter: ListItemAdapter
    lateinit var mWhyShouldHireAdapter: ListItemAdapter

    companion object {
        val IE_JOB_ID: String = "jobId"
        val IE_SEEEKER_ID: String = "seekerId"
        fun newIntent(context: Context, jobId: String, seekerId: Int): Intent {
            val intent = Intent(context, ApplicantProfileActivity::class.java)
            intent.putExtra(IE_JOB_ID, jobId)
            intent.putExtra(IE_SEEEKER_ID, seekerId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_applicant_profile)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mPresenter = ApplicantPresenter(this)
        mSkillsAdapter = ListItemAdapter(applicationContext)
        mWhyShouldHireAdapter = ListItemAdapter(applicationContext)

        val jobId = intent.getStringExtra(IE_JOB_ID)
        val seekerId = intent.getStringExtra(IE_SEEEKER_ID)

        rvSkill.adapter = mSkillsAdapter
        rvSkill.layoutManager = LinearLayoutManager(this)
        rvWhyShouldHire.adapter = mWhyShouldHireAdapter
        rvWhyShouldHire.layoutManager = LinearLayoutManager(this)
        mPresenter.getSkills(jobId, seekerId.toString()).observe(this, Observer<List<String>> { response ->
            if (response != null) {
                displaySkills(response)
            }
        })
        mPresenter.getWhyShouldHire(jobId, seekerId.toString()).observe(this, Observer<List<String>> { response ->
            if (response != null) {
                displayWhyShouldHire(response)
            }
        })
    }

    override fun displaySkills(skills: List<String>) {
        if (skills.isNotEmpty()) {
            mSkillsAdapter.setNewList(skills)
            tvSkills.visibility = View.VISIBLE
        } else
            tvSkills.visibility = View.GONE
    }

    override fun displayWhyShouldHire(whyShouldHires: List<String>) {
        if (whyShouldHires.isNotEmpty()) {
            mWhyShouldHireAdapter.setNewList(whyShouldHires)
            tvWhyShouldHire.visibility = View.VISIBLE
        } else
            tvWhyShouldHire.visibility = View.GONE
    }

    override fun displayMessage(message: String) {

    }

}
