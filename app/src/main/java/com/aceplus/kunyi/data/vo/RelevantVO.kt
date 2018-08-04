package com.aceplus.kunyi.data.vo

/**
 * Created by kkk on 7/30/2018.
 */

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RelevantVO {

    @SerializedName("relevancyPercentage")
    @Expose
    var relevancyPercentage: Double? = null
    @SerializedName("seekerId")
    @Expose
    var seekerId: Int? = null
    @SerializedName("seekerName")
    @Expose
    var seekerName: String? = null
    @SerializedName("seekerProfilePicUrl")
    @Expose
    var seekerProfilePicUrl: String? = null
    @SerializedName("seekerSkill")
    @Expose
    var seekerSkill: List<SeekerSkillVO>? = null
    @SerializedName("whyRelevant")
    @Expose
    var whyRelevant: String? = null

}