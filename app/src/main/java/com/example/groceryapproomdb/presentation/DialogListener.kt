package com.example.groceryapproomdb.presentation

import com.example.groceryapproomdb.room.GroceryEntities

interface DialogListener {

    fun onAddButtonClicked(item:GroceryEntities)
}