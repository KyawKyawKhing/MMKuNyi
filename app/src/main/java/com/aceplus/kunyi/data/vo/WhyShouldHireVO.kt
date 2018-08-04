package com.aceplus.kunyi.data.vo

/**
 * Created by kkk on 7/30/2018.
 */

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WhyShouldHireVO {

    @SerializedName("msg")
    @Expose
    var msg: String? = null
    @SerializedName("timestamp")
    @Expose
    var timestamp: String? = null
    @SerializedName("whyShouldHireId")
    @Expose
    var whyShouldHireId: Int? = null

}