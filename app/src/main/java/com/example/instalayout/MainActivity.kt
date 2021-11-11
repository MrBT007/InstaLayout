package com.example.instalayout

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    lateinit var button: Button
    lateinit var userID: EditText
    lateinit var password: EditText
    lateinit var error: TextView
    val LoginID = "tushar"
    val LoginPassword = "tushar007"
    var EXTRA_NAME = "com.example.instalayout.extra.NAME"
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        userID = findViewById(R.id.userID)
        password = findViewById(R.id.password)
        error = findViewById(R.id.textView2)

        button.setOnClickListener {
            var userid = userID.text.toString()
            var pswrd = password.text.toString()

            if(userid == LoginID && pswrd == LoginPassword)
            {
                Toast.makeText(applicationContext, "Thanks for Login", Toast.LENGTH_SHORT).show()
                val intent = Intent(this,MainActivity2::class.java)
                intent.putExtra(EXTRA_NAME,userid)
                startActivity(intent)
            }
            else if(userid == LoginID && pswrd != LoginPassword)
            {
                error.text = "Your password was incorrect. Please double-check your password"
            }
            else
            {
                error.text = "Sorry, user doesn't exist"
            }
        }
    }
}