package com.raywenderlich.cheesefinder.database

import androidx.room.*

@Dao
interface CheeseDao {

    @Query("SELECT * FROM cheeses WHERE name LIKE :name")
    fun findCheese(name: String): List<Cheese>

    @Query("SELECT favorite FROM cheeses WHERE :id LIMIT 1")
    fun isFavorite(id: Long): Int

    @Update
    fun favoriteCheese(cheese: Cheese): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(cheeses: List<Cheese>): List<Long>
}