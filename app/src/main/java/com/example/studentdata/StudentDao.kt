package com.example.studentdata

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@androidx.room.Dao
interface StudentDao {

    @Query("SELECT * FROM students ORDER BY roll_no DESC")
    fun getAlphabetizedWords(): Flow<List<Student>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(student: Student)

    @Query("DELETE FROM students")
    suspend fun deleteAll()
}