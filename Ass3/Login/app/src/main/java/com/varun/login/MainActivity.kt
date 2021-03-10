package com.varun.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.varun.login.view.activity.registration.FormFirst
import com.varun.login.view.activity.admin.Dashboard

const val USERNAME = "com.example.login.view.USERNAME"

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
//        if(true){
        if(username.toLowerCase() == "admin" && password == "root"){
//            Toast.makeText(applicationContext, "Login Successful" ,Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Dashboard::class.java).apply{
                putExtra(USERNAME, username)
            }
            startActivity(intent)
        }
        else Toast.makeText(applicationContext, "Login Unsuccessful" ,Toast.LENGTH_SHORT).show()
    }

    fun registration(view: View){
        val intent = Intent(this, FormFirst::class.java).apply{}
        startActivity(intent)
    }

}