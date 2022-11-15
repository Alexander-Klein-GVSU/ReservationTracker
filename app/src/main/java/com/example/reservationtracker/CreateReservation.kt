package com.example.reservationtracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import android.widget.Toast

class CreateReservation : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_reservation)
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
                return@setOnClickListener
            }

            if (auth.fetchSignInMethodsForEmail(email).isComplete) {
                // Add data to firebase.
                return@setOnClickListener
            }

            this.finish()
        }

        backBtn.setOnClickListener {
            this.finish()
        }
    }
}