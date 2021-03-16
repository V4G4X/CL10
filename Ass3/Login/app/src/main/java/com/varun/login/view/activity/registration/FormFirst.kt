package com.varun.login.view.activity.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.varun.login.ADMIN_LOGGED_IN
import com.varun.login.R

const val FIRSTNAME = "com.varun.login.view.FIRSTNAME"
const val LASTNAME = "com.varun.login.view.LASTNAME"
const val EMAIL = "com.varun.login.view.EMAIL"
const val PHONE = "com.varun.login.view.PHONE"

class FormFirst : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_first)
    }

    fun fillDetails(view: View) {

        fun personalInputCheck(firstName: String, lastName: String, emailAddress: String, phone: String): Boolean{
            return !(TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName) || TextUtils.isEmpty(emailAddress) || TextUtils.isEmpty(phone))
        }

        val firstNameView = findViewById<EditText>(R.id.firstName)
        val firstName = firstNameView.text.toString()

        val lastNameView = findViewById<EditText>(R.id.lastName)
        val lastName = lastNameView.text.toString()

        val emailAddressView = findViewById<EditText>(R.id.emailAddress)
        val emailAddress = emailAddressView.text.toString()

        val phoneView = findViewById<EditText>(R.id.phone)
        val phone = phoneView.text.toString()

        if(personalInputCheck(firstName,lastName,emailAddress,phone)){
            Toast.makeText(applicationContext, "Fill Professional Details", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, FormSecond::class.java).apply {
                putExtra(FIRSTNAME, firstName)
                putExtra(LASTNAME, lastName)
                putExtra(EMAIL, emailAddress)
                putExtra(PHONE, phone)
                putExtra(ADMIN_LOGGED_IN, intent.getStringExtra(ADMIN_LOGGED_IN))
            }
            startActivity(intent)
        }
        else
            Toast.makeText(applicationContext, "Fill all Data Fields", Toast.LENGTH_SHORT).show()
    }
}