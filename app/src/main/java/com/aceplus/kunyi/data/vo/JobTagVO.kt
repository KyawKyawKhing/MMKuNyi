package com.aceplus.kunyi.data.vo

/**
 * Created by kkk on 7/30/2018.
 */

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class JobTagVO {

    @SerializedName("desc")
    @Expose
    var desc: String? = null
    @SerializedName("jobCountWithTag")
    @Expose
    var jobCountWithTag: Int? = null
    @SerializedName("tag")
    @Expose
    var tag: String? = null
    @SerializedName("tagId")
    @Expose
    var tagId: Int? = null

}