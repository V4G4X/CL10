package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class FormSecond : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_second)
    }

    fun writeToDB(view: View) {
        val degreeView = findViewById<EditText>(R.id.degree)
        val degree = degreeView.text.toString()
        val collegeView = findViewById<EditText>(R.id.college)
        val college = collegeView.text.toString()
        val gradYearView = findViewById<EditText>(R.id.gradYear)
        val gradYear = gradYearView.text.toString()
        val branchView = findViewById<EditText>(R.id.branch)
        val branch = branchView.text.toString()

        Toast.makeText(applicationContext, "Writing to DataBase", Toast.LENGTH_LONG).show()

    }
}