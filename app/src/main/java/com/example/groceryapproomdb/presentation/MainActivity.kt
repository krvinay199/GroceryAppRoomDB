  package com.example.groceryapproomdb.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.groceryapproomdb.R
import com.example.groceryapproomdb.room.GroceryDatabase
import com.example.groceryapproomdb.room.GroceryEntities
import com.example.groceryapproomdb.room.GroceryRepository
import com.example.groceryapproomdb.viewModel.GroceryViewModel
import com.example.groceryapproomdb.viewModel.GroceryViewModelFactory
import com.example.grocerylist.UI.GroceryItemDialog
import kotlinx.android.synthetic.main.activity_main.*

  class MainActivity : AppCompatActivity() {
        lateinit var viewModel: GroceryViewModel
        lateinit var list: List<GroceryEntities>

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val groceryRepository = GroceryRepository(GroceryDatabase(this))
            val factory = GroceryViewModelFactory(groceryRepository)

            // Initialised View Model
            viewModel = ViewModelProvider(this, factory).get(GroceryViewModel::class.java)
            val groceryAdapter = GroceryAdapter(listOf(), viewModel)
            rvList.layoutManager = LinearLayoutManager(this)
            rvList.adapter = groceryAdapter

            // To display all items in recycler view
            viewModel.allGroceryItems().observe(this, Observer {
                groceryAdapter.list = it
                groceryAdapter.notifyDataSetChanged()
            })

            // on ClickListener on button to open dialog box
            btnAdd.setOnClickListener {
                GroceryItemDialog(this, object : DialogListener {
                    override fun onAddButtonClicked(item: GroceryEntities) {
                        viewModel.insert(item)
                    }
                }).show()
            }
        }
}