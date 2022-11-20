package com.example.reservationtracker

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore

class CreateReservation : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_reservation)
        val db = Firebase.firestore

        val emailText = findViewById<EditText>(R.id.createEmail)
        val nameText = findViewById<EditText>(R.id.createName)
        val timeEstText = findViewById<EditText>(R.id.createTime)
        val sizeText = findViewById<EditText>(R.id.createTableSize)
        val createBtn = findViewById<Button>(R.id.createCreate)
        val backBtn = findViewById<Button>(R.id.createBack)

        createBtn.setOnClickListener {
            val email = emailText.text.toString()
            val name = nameText.text.toString()
            val timeVal = timeEstText.text.toString()
            val sizeVal = sizeText.text.toString()

            if (email == "" || name == "" || timeVal == "" || sizeVal == "") {
                if (auth.fetchSignInMethodsForEmail(email).isComplete) {
                    // Create a new reservation entry
                    val user = hashMapOf(
                        "email" to "" + emailText,
                        "name" to "" + nameText,
                        "time" to "" + timeEstText,
                        "size" to sizeText
                    )

// Add a new document with a generated ID
                    db.collection("users")
                        .add(user)
                        .addOnSuccessListener { documentReference ->
                            Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                        }
                        .addOnFailureListener { e ->
                            Log.w(TAG, "Error adding document", e)
                        }
                    return@setOnClickListener
                }
            }

            this.finish()
        }

        backBtn.setOnClickListener {
            this.finish()
        }


    }
}