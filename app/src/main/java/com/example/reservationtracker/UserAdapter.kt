package com.example.reservationtracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter (private val mList: List<UserData>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_template, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var itemName: TextView
        private var itemTable: TextView
        private var itemTime: TextView

        init {
            itemName = itemView.findViewById(R.id.utempName)
            itemTable = itemView.findViewById(R.id.utempTable)
            itemTime = itemView.findViewById(R.id.utempTime)
        }
    }
}