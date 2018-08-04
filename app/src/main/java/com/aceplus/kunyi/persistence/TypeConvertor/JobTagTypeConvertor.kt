package com.aceplus.kunyi.persistence.TypeConvertor

import android.arch.persistence.room.TypeConverter
import android.arch.persistence.room.TypeConverters
import com.aceplus.kunyi.data.vo.JobTagVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by kkk on 8/2/2018.
 */

class JobTagTypeConvertor {

    @TypeConverter
    fun toString(jobTagVO: List<JobTagVO>): String {
        val gson = Gson()
        return gson.toJson(jobTagVO)
    }

    @TypeConverter
    fun toVOS(data: String): List<JobTagVO> {
        val gson = Gson()
        return gson.fromJson(data, object : TypeToken<List<JobTagVO>>() {
        }.type)
    }
}