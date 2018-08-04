package com.aceplus.kunyi.persistence.TypeConvertor

import android.arch.persistence.room.TypeConverter
import com.aceplus.kunyi.data.vo.RelevantVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by kkk on 8/2/2018.
 */

class RelevantTypeConvertor {

    @TypeConverter
    fun toString(relavantVO: List<RelevantVO>): String {
        val gson = Gson()
        return gson.toJson(relavantVO)
    }

    @TypeConverter
    fun toVOS(data: String): List<RelevantVO> {
        val gson = Gson()
        return gson.fromJson(data, object : TypeToken<List<RelevantVO>>() {
        }.type)
    }
}