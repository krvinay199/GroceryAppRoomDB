package com.example.groceryapproomdb.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryapproomdb.R
import com.example.groceryapproomdb.room.GroceryEntities
import com.example.groceryapproomdb.viewModel.GroceryViewModel
import kotlinx.android.synthetic.main.layout_grocery.view.*

class GroceryAdapter(var list: List<GroceryEntities>, private val viewModel: GroceryViewModel) :
    RecyclerView.Adapter<GroceryAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_grocery,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var currentPosition = list[position]
        holder.itemView.txtItemName.text = currentPosition.itemName
        holder.itemView.txtItemPrice.text = "${currentPosition.itemPrice}"
        holder.itemView.txtItemQuantity.text = "${currentPosition.itemQuantity}"
        holder.itemView.ibDelete.setOnClickListener {
            viewModel.delete(currentPosition)
        }

        // To get total cost
        if (position == list.size - 1) {
            var totalCost = 0
            for (i in 0 until list.size) {
                totalCost += list[i].itemPrice
            }
            holder.itemView.txtItemTotalCost.visibility = View.VISIBLE
            holder.itemView.txtTotalCostTitle.visibility = View.VISIBLE
            holder.itemView.txtItemTotalCost.text = "$totalCost"
        }
    }

    override fun getItemCount(): Int = list.size

}