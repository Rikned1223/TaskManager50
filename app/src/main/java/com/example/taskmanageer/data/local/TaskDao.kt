package com.example.taskmanageer.data.local

import androidx.room.*
import com.example.taskmanageer.ui.model.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM task ORDER BY id DESC")
    fun getAll(): List<Task>

    @Insert
    fun insert(task: Task)

    @Delete
    fun delete(task: Task)

    @Update
    fun update(task: Task)

}