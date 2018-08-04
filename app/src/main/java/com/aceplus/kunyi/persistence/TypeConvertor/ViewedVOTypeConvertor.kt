package com.aceplus.kunyi.persistence.TypeConvertor

import android.arch.persistence.room.TypeConverter
import com.aceplus.kunyi.data.vo.ViewedVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by kkk on 8/2/2018.
 */
class ViewedVOTypeConvertor {

    @TypeConverter
    fun toString(viewVOS: List<ViewedVO>): String {
        val gson = Gson()
        return gson.toJson(viewVOS)
    }

    @TypeConverter
    fun toVOS(data: String): List<ViewedVO> {
        val gson = Gson()
        return gson.fromJson(data, object : TypeToken<List<ViewedVO>>() {
        }.type)
    }
}