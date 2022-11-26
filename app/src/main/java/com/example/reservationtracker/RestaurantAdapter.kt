package com.example.reservationtracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestaurantAdapter (private val mList: List<UserData>): RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_template, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = mList[position]
        holder.itemName.text = item.name
        holder.itemTime.text = item.time
        holder.itemTable.text = item.tSize
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemName: TextView = itemView.findViewById(R.id.rtempName)
        var itemTable: TextView = itemView.findViewById(R.id.rtempTable)
        var itemTime: TextView = itemView.findViewById(R.id.rtempTime)
    }
}