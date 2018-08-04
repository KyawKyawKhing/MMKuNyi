package com.aceplus.kunyi.data.vo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by hakerfaker on 7/30/2018.
 */

class SeekerSkillVO {

    @SerializedName("skillId")
    @Expose
    var skillId: Int? = null
    @SerializedName("skillName")
    @Expose
    var skillName: String? = null

}