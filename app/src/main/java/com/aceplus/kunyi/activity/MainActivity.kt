package com.aceplus.kunyi.activity

import android.app.Dialog
import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import com.aceplus.kunyi.R
import com.aceplus.kunyi.adapter.JobsAdapter
import com.aceplus.kunyi.adapter.ListItemAdapter
import com.aceplus.kunyi.data.vo.JobsVO
import com.aceplus.kunyi.mvp.presenter.JobsPresenter
import com.aceplus.kunyi.mvp.view.JobsView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.seeker_show_listitem.view.*
import kotlinx.android.synthetic.main.view_pod_empty.*

class MainActivity : BaseActivity(), JobsView {

    lateinit var mAdapter: JobsAdapter
    lateinit var mPresenter: JobsPresenter
    //    lateinit var dialog: Dialog
    lateinit var mSeekerAdapter: ListItemAdapter

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUISetUp()
        mPresenter.getJobsList().observe(this, Observer<List<JobsVO>> { response ->
            displayJobsList(response!!)
        })
        btnRefreshEmpty.setOnClickListener { mPresenter.loadData() }
        fabJobPost.setOnClickListener { goToJobPostActivity() }
    }

    private fun initUISetUp() {
        mPresenter = JobsPresenter(this)
        mAdapter = JobsAdapter(applicationContext, mPresenter)
        rvJob.adapter = mAdapter
        rvJob.layoutManager = LinearLayoutManager(this)


    }

    private fun goToJobPostActivity() {
        val intent = JobPostActivity.newIntent(applicationContext)
        startActivity(intent)
    }

    override fun displayProgressBar(visible: Int) {
        progressBar.visibility = visible
    }

    override fun displayJobsList(jobs: List<JobsVO>) {
        displayProgressBar(View.GONE)
        if (jobs.isNotEmpty()) {
            mAdapter.setNewList(jobs)
            emptyView.visibility = View.GONE
        } else {
            emptyView.visibility = View.VISIBLE
        }
    }

    override fun displayJobsDetail(id: Int) {
        val intent = JobDetailActivity.newIntent(applicationContext, id)
        startActivity(intent)
    }

    override fun displayMessage(message: String) {

    }

    override fun displaySeekers(title: String, seekerList: List<String>) {
        val dialog = Dialog(this, android.R.style.Theme_Black_NoTitleBar_Fullscreen)
        val view = LayoutInflater.from(this).inflate(R.layout.seeker_show_listitem, null)
        dialog.setContentView(view)
        dialog.window.attributes.windowAnimations = R.style.DialogAnimation
        dialog.show()
        mSeekerAdapter = ListItemAdapter(applicationContext)
        view.rvSeeker.adapter = mSeekerAdapter
        view.rvSeeker.layoutManager = LinearLayoutManager(this)
        view.seekerTitle.text = title
        mSeekerAdapter.setNewList(seekerList)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}
