package com.aceplus.kunyi.persistence.TypeConvertor

import android.arch.persistence.room.TypeConverter
import android.arch.persistence.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by kkk on 8/2/2018.
 */
class ImagesTypeConvertor {

    @TypeConverter
    fun toString(images: List<String>): String {
        val gson = Gson()
        return gson.toJson(images)
    }

    @TypeConverter
    fun toVOS(data: String): List<String> {
        val gson = Gson()
        return gson.fromJson(data, object : TypeToken<List<String>>() {
        }.type)
    }
}