package com.aceplus.kunyi.persistence.Dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.aceplus.kunyi.data.vo.JobsVO

/**
 * Created by kkk on 8/1/2018.
 */
@Dao
interface JobsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(dataList: List<JobsVO>)

    @Query("select * from jobs")
    fun getAllData(): LiveData<List<JobsVO>>

    @Query("select * from jobs where jobPostId =:id")
    fun getDataById(id: String): LiveData<JobsVO>

}