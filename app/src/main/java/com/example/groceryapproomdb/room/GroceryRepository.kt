package com.example.groceryapproomdb.room

import androidx.room.Insert

class GroceryRepository(private val db : GroceryDatabase) {

    suspend fun insert(item : GroceryEntities) = db.getGroceryDao().Insert(item)
    suspend fun delete(item : GroceryEntities) = db.getGroceryDao().Delete(item)

    fun allGroceryItems() = db.getGroceryDao().getAllGroceryItems()


}