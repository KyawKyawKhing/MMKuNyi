package com.aceplus.kunyi.data.vo

/**
 * Created by kkk on 7/30/2018.
 */
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class OfferAmountVO {

    @SerializedName("amount")
    @Expose
    var amount: Int? = null
    @SerializedName("duration")
    @Expose
    var duration: String? = null

}