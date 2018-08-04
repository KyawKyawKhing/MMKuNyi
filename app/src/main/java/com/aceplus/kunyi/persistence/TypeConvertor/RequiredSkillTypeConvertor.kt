package com.aceplus.kunyi.persistence.TypeConvertor

import android.arch.persistence.room.TypeConverter
import android.arch.persistence.room.TypeConverters
import com.aceplus.kunyi.data.vo.RequiredSkillVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by kkk on 8/2/2018.
 */

class RequiredSkillTypeConvertor {

    @TypeConverter
    fun toString(requiredSkillVOS: List<RequiredSkillVO>): String {
        val gson = Gson()
        return gson.toJson(requiredSkillVOS)
    }

    @TypeConverter
    fun toVOS(data: String): List<RequiredSkillVO> {
        val gson = Gson()
        return gson.fromJson(data, object : TypeToken<List<RequiredSkillVO>>() {
        }.type)
    }
}