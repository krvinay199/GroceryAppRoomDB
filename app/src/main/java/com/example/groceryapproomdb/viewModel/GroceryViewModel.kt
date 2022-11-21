package com.example.groceryapproomdb.viewModel

import androidx.lifecycle.ViewModel
import com.example.groceryapproomdb.room.GroceryEntities
import com.example.groceryapproomdb.room.GroceryRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GroceryViewModel(private val repository: GroceryRepository) : ViewModel() {

    fun insert(item : GroceryEntities) = GlobalScope.launch {
        repository.insert(item)
    }

    fun delete(item: GroceryEntities) = GlobalScope.launch {
        repository.delete(item)
    }

    fun allGroceryItems() = repository.allGroceryItems()

}