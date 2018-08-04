package com.aceplus.kunyi.data.vo

/**
 * Created by kkk on 7/30/2018.
 */

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RequiredSkillVO {

    @SerializedName("skillId")
    @Expose
    var skillId: Int? = null
    @SerializedName("skillName")
    @Expose
    var skillName: String? = null

}