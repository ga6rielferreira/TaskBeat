package com.devspace.taskbeats.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CategoryDao {

    @Query("SELECT * FROM category_entity")
    fun getAll(): List<CategoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(categoryEntity: List<CategoryEntity>)
}

