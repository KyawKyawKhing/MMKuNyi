package com.aceplus.kunyi.persistence.TypeConvertor

import android.arch.persistence.room.TypeConverter
import com.aceplus.kunyi.data.vo.InterestedVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by kkk on 8/2/2018.
 */

class InterestedTypeConvertor {

    @TypeConverter
    fun toString(interestedVO: List<InterestedVO>): String {
        val gson = Gson()
        return gson.toJson(interestedVO)
    }

    @TypeConverter
    fun toVOS(data: String): List<InterestedVO> {
        val gson = Gson()
        return gson.fromJson(data, object : TypeToken<List<InterestedVO>>() {
        }.type)
    }
}