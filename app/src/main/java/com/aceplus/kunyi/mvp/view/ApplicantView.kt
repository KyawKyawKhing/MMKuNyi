package com.aceplus.kunyi.mvp.view

/**
 * Created by kkk on 8/2/2018.
 */
interface ApplicantView : BaseView {
    fun displaySkills(skills: List<String>)
    fun displayWhyShouldHire(whyShouldHire: List<String>)
}