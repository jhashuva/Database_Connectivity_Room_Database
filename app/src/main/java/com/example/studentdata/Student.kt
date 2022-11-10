package com.example.studentdata

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
class Student(@PrimaryKey @ColumnInfo(name="roll_no") val rollNumber:String,
    @ColumnInfo(name="name") val name:String)