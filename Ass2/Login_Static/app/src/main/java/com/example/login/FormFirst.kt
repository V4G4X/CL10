package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

const val FIRSTNAME = "com.example.login.FIRSTNAME"
const val LASTNAME = "com.example.login.LASTNAME"
const val EMAIL = "com.example.login.EMAIL"
const val PHONE = "com.example.login.PHONE"

class FormFirst : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_first)
    }

    fun fillDetails(view: View) {
        val firstNameView = findViewById<EditText>(R.id.firstName)
        val firstName = firstNameView.text.toString()
        val lastNameView = findViewById<EditText>(R.id.lastName)
        val lastName = lastNameView.text.toString()
        val emailAddressView = findViewById<EditText>(R.id.emailAddress)
        val emailAddress = emailAddressView.text.toString()
        val phoneView = findViewById<EditText>(R.id.phone)
        val phone = phoneView.text.toString()
        val intent = Intent(this, FormSecond::class.java).apply {
            putExtra(FIRSTNAME, firstName)
            putExtra(LASTNAME, lastName)
            putExtra(EMAIL, emailAddress)
            putExtra(PHONE, phone)
        }
        startActivity(intent)
    }

}