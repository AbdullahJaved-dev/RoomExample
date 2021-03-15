package com.devhouse.roomexample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by Abdullah on 3/15/2021.
 */

@Entity(tableName = "user_table")
data class User(
        @PrimaryKey(autoGenerate = true) val id: Int,
        @ColumnInfo(name = "userName") val name: String
)

