package com.example.groceryapproomdb.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GroceryDao {

    @Query("SELECT * FROM grocery_items")
    fun getAllGroceryItems() : LiveData<List<GroceryEntities>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun Insert(item:GroceryEntities)

    @Delete
    fun Delete(item: GroceryEntities)


}