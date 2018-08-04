package com.aceplus.kunyi.data.vo

/**
 * Created by kkk on 7/30/2018.
 */
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class JobDurationVO {

    @SerializedName("jobEndDate")
    @Expose
    var jobEndDate: String? = null
    @SerializedName("jobStartDate")
    @Expose
    var jobStartDate: String? = null
    @SerializedName("totalWorkingDays")
    @Expose
    var totalWorkingDays: Int? = null
    @SerializedName("workingDaysPerWeek")
    @Expose
    var workingDaysPerWeek: Int? = null
    @SerializedName("workingHoursPerDay")
    @Expose
    var workingHoursPerDay: Int? = null

}