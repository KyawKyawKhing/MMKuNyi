package com.aceplus.kunyi.data.vo

/**
 * Created by kkk on 7/30/2018.
 */

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ApplicantVO {

    @SerializedName("appliedDate")
    @Expose
    var appliedDate: String? = null
    @SerializedName("canLowerOfferAmount")
    @Expose
    var canLowerOfferAmount: Boolean? = null
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
    @SerializedName("whyShouldHire")
    @Expose
    var whyShouldHire: List<WhyShouldHireVO>? = null

}