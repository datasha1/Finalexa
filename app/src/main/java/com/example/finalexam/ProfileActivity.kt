package com.example.finalexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    private lateinit var userInfoTextView: TextView

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        mAuth = FirebaseAuth.getInstance()

        userInfoTextView = findViewById(R.id.userInfoTextView)

        userInfoTextView.text = mAuth.currentUser?.displayName

        profileButton.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }

        QuoteButton.setOnClickListener{
            startActivity(Intent(this, QuoteActivity::class.java))
            finish()
        }

        LogOut.setOnClickListener {
            mAuth.signOut()
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }

    }
}