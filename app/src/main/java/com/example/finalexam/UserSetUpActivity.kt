package com.example.finalexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_user_set_up.*

class UserSetUpActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var profilePictureUrlEditText: EditText
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView

    private lateinit var mAuth: FirebaseAuth
    private lateinit var db: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_set_up)

        mAuth = FirebaseAuth.getInstance()
        db = FirebaseDatabase.getInstance().getReference("PersonInfo")

        nameEditText = findViewById(R.id.nameEditText)
        profilePictureUrlEditText = findViewById(R.id.profilePictureEditText)
        imageView = findViewById(R.id.imageView2)
        textView = findViewById(R.id.textView3)

        //logoutButton.setOnClickListener{startActivity(Intent())}

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val url = profilePictureUrlEditText.text.toString()

            val personInfo = PersonInfo(name, url)

            if (mAuth.currentUser?.uid != null) {

                db.child(mAuth.currentUser?.uid!!).setValue(personInfo)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
                            nameEditText.text = null
                            profilePictureUrlEditText.text = null
                        } else {
                            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                        }
                    }
                    .addOnCompleteListener { personInfo ->
                        if (personInfo.isSuccessful) {
                            startActivity(Intent(this, SignInActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(this, "Insert Name!", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
        if (mAuth.currentUser?.uid != null) {

            db.child(mAuth.currentUser?.uid!!).addValueEventListener(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {
                    val p = snapshot.getValue(PersonInfo::class.java)

                    if (p != null) {

                        textView3.text = p.name


                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@UserSetUpActivity, "Error", Toast.LENGTH_SHORT).show()
                }

            })

        }
    }
}
