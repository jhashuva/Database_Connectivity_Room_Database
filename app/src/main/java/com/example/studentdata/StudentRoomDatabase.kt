package com.example.studentdata

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Student::class), version = 1, exportSchema = false)
public abstract class StudentRoomDatabase: RoomDatabase() {
    abstract fun studentDao(): StudentDao
    private class WordDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var studentDao = database.studentDao()

                    // Delete all content here.
                    studentDao.deleteAll()

                    // Add sample words.
                    var student = Student("19B81A0501", "Andrew Flemmings")
                    studentDao.insert(student)
                    student = Student("19B81A0502", "Regina Filange")
                    studentDao.insert(student)

                }
            }
        }

        companion object {
            // Singleton prevents multiple instances of database opening at the
            // same time.
            @Volatile
            private var INSTANCE: StudentRoomDatabase? = null

            fun getDatabase(context: Context): StudentRoomDatabase {
                // if the INSTANCE is not null, then return it,
                // if it is, then create the database
                return INSTANCE ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        StudentRoomDatabase::class.java,
                        "student_database"
                    ).build()
                    INSTANCE = instance
                    // return instance
                    instance
                }
            }
        }
    }
}