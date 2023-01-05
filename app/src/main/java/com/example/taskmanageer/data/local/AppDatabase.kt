package com.example.taskmanageer.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.taskmanageer.ui.model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao() :TaskDao
}