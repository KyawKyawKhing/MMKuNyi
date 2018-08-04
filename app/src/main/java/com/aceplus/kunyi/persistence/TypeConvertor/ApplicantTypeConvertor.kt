package com.aceplus.kunyi.persistence.TypeConvertor

import android.arch.persistence.room.TypeConverter
import com.aceplus.kunyi.data.vo.ApplicantVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by kkk on 8/2/2018.
 */
class ApplicantTypeConvertor {

    @TypeConverter
    fun toString(applicantVOS: List<ApplicantVO>): String {
        val gson = Gson()
        return gson.toJson(applicantVOS)
    }

    @TypeConverter
    fun toVOS(data: String): List<ApplicantVO> {
        val gson = Gson()
        return gson.fromJson(data, object : TypeToken<List<ApplicantVO>>() {
        }.type)
    }
}