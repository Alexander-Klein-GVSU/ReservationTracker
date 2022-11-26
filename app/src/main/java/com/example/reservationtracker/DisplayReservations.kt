package com.example.reservationtracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.awaitAll

class DisplayReservations : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val db = Firebase.firestore
    private var reservationList: MutableList<UserData> = mutableListOf()

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RestaurantAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_reservations)

        auth = Firebase.auth

        val reserveBtn = findViewById<FloatingActionButton>(R.id.restaurantAddRes)

        fun getReservations(usrRcyclr: RecyclerView) {
            reservationList = mutableListOf()
            val docRef = auth.currentUser?.let { auth.currentUser!!.email?.let { it1 ->
                db.collection("Restaurant").document(
                    it1
                ).collection("Reservations")
            } }

            docRef?.get()?.addOnSuccessListener {
                for (item in it.documents) {
                    val reservation = UserData(item.data!!["name"] as String, item.data!!["sizeVal"] as String, item.data!!["timeVal"] as String)
                    reservationList.add(reservation)
                }
                layoutManager = LinearLayoutManager(this)
                usrRcyclr.layoutManager = layoutManager

                adapter = RestaurantAdapter(reservationList)
                usrRcyclr.adapter = adapter
            }
        }
        val usrRcyclr = findViewById<RecyclerView>(R.id.restaurantRecycler)

        getReservations(usrRcyclr)

        reserveBtn.setOnClickListener {
            val i = Intent(this, CreateReservation::class.java)
            startActivity(i)
        }

        val refreshBtn = findViewById<FloatingActionButton>(R.id.displayRefresh)
        refreshBtn.setOnClickListener {
            getReservations(usrRcyclr)
        }
    }
}