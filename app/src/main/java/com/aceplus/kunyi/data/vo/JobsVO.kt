package com.aceplus.kunyi.data.vo

/**
 * Created by kkk on 7/30/2018.
 */

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.aceplus.kunyi.persistence.TypeConvertor.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.reactivex.annotations.NonNull

@Entity(tableName = "jobs")
@TypeConverters(ApplicantTypeConvertor::class, ImagesTypeConvertor::class, InterestedTypeConvertor::class,
        JobTagTypeConvertor::class, RelevantTypeConvertor::class, RequiredSkillTypeConvertor::class,
        ViewedVOTypeConvertor::class)
class JobsVO {

    //    @NonNull
//    @PrimaryKey
//    @ColumnInfo(name = "id")
//    var id: Int? = null
    @NonNull
    @PrimaryKey
    @SerializedName("jobPostId")
    @Expose
    var jobPostId: Int? = null

    @SerializedName("applicant")
    @Expose
    var applicant: List<ApplicantVO>? = null

    @SerializedName("availablePostCount")
    @Expose
    var availablePostCount: Int? = null

    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("fullDesc")
    @Expose
    var fullDesc: String? = null

    @SerializedName("genderForJob")
    @Expose
    var genderForJob: Int? = null


    @SerializedName("images")
    @Expose
    var images: List<String>? = null


    @SerializedName("importantNotes")
    @Expose
    var importantNotes: List<String>? = null

    @SerializedName("interested")
    @Expose
    var interested: List<InterestedVO>? = null

    @SerializedName("isActive")
    @Expose
    var isActive: Boolean? = null


    @Embedded
    @SerializedName("jobDuration")
    @Expose
    var jobDuration: JobDurationVO? = null


    @SerializedName("jobTags")
    @Expose
    var jobTags: List<JobTagVO>? = null

    @SerializedName("location")
    @Expose
    var location: String? = null

    @SerializedName("makeMoneyRating")
    @Expose
    var makeMoneyRating: Int? = null

    @Embedded
    @SerializedName("offerAmount")
    @Expose
    var offerAmount: OfferAmountVO? = null

    @SerializedName("phoneNo")
    @Expose
    var phoneNo: String? = null

    @SerializedName("postClosedDate")
    @Expose
    var postClosedDate: String? = null

    @SerializedName("postedDate")
    @Expose
    var postedDate: String? = null

    @SerializedName("relevant")
    @Expose
    var relevant: List<RelevantVO>? = null

    @SerializedName("requiredSkill")
    @Expose
    var requiredSkill: List<RequiredSkillVO>? = null

    @SerializedName("shortDesc")
    @Expose
    var shortDesc: String? = null

    @SerializedName("viewed")
    @Expose
    var viewed: List<ViewedVO>? = null

}