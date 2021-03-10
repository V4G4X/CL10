package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

const val USERNAME = "com.example.login.USERNAME"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun login_auth(view: View){
        val usernameObj = findViewById<EditText>(R.id.username)
        val username = usernameObj.text.toString()
        val passwordObj = findViewById<EditText>(R.id.password)
        val password = passwordObj.text.toString()
        if(username.toLowerCase() == "varun" && password == "12345678"){
            Toast.makeText(applicationContext, "Login Successful" ,Toast.LENGTH_SHORT).show()
            val intent = Intent(this, FormFirst::class.java).apply{
                putExtra(USERNAME, username)
            }
            startActivity(intent)
        }
        else Toast.makeText(applicationContext, "Login Unsuccessful" ,Toast.LENGTH_SHORT).show()
    }
}