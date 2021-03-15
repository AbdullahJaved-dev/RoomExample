package com.devhouse.roomexample

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by Abdullah on 3/15/2021.
 */

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("DELETE from user_table")
    suspend fun deleteAll()

    @Query("select * from user_table")
    suspend fun getAllUsers():List<User>

}