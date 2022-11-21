package com.example.reservationtracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class displayReservations : AppCompatActivity() {

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
        setContentView(R.layout.activity_display_reservations)

        /*val docRef = auth.currentUser?.let { db.collection("Restaurant").document(it.uid).collection("Reservations") }
        docRef?.get()?.addOnSuccessListener {
            val reservations = ArrayList<Reservation>()
            for (item in it.documents) {
                val reservation = Reservation()
                reservation.name = item.data!!["name"] as String?
                reservation.email = item.data!!["email"] as String?
                reservation.timeVal = item.data!!["timeVal"] as String?
                reservation.sizeVal = item.data!!["sizeVal"] as String
                reservations.add(reservation)
            }
        }*/
    }
}