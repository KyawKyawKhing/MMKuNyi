package com.aceplus.kunyi.mvp.presenter

import android.arch.lifecycle.MutableLiveData
import com.aceplus.kunyi.data.model.KuNyiModel
import com.aceplus.kunyi.mvp.view.ApplicantView

/**
 * Created by kkk on 8/2/2018.
 */
class ApplicantPresenter(view: ApplicantView) : BasePresenter<ApplicantView>(view) {
    private val kuNyiModel: KuNyiModel = KuNyiModel.getInstance()

    fun getSkills(jobId: String, seekderId: String): MutableLiveData<List<String>> {
        var liveData: MutableLiveData<List<String>> = MutableLiveData()
        kuNyiModel.getDataById(jobId).observeForever { response ->
            if (response != null) {
                val skills = ArrayList<String>()
                response.applicant!!
                        .filter { it.seekerId.toString() == seekderId }
                        .forEach { applicant -> applicant.seekerSkill!!.mapTo(skills) { it.skillName!! } }
                liveData.value = skills
            }
        }
        return liveData
    }

    fun getWhyShouldHire(jobId: String, seekderId: String): MutableLiveData<List<String>> {
        var liveData: MutableLiveData<List<String>> = MutableLiveData()
        kuNyiModel.getDataById(jobId).observeForever { response ->
            if (response != null) {
                val whyShouldHire = ArrayList<String>()
                response.applicant!!
                        .filter { it.seekerId.toString() == seekderId }
                        .forEach { applicant -> applicant.whyShouldHire!!.mapTo(whyShouldHire) { it.msg!! } }
                liveData.value = whyShouldHire
            }
        }
        return liveData
    }
}