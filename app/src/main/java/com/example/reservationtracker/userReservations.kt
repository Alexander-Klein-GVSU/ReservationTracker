package com.example.reservationtracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class userReservations : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val db = Firebase.firestore
    data class Reservation(
        var email: String? = null,
        var name: String? = null,
        var timeVal: String? = null,
        var sizeVal: String? = null
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_reservations)

        val refreshBtn = findViewById<FloatingActionButton>(R.id.userRefresh)
        val usrRcyclr = findViewById<RecyclerView>(R.id.userRecycler)


    }
}