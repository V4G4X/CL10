package com.varun.login.view.activity.registration

import android.content.Intent
import android.graphics.DashPathEffect
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.varun.login.ADMIN_LOGGED_IN
import com.varun.login.MainActivity
import com.varun.login.R
import com.varun.login.model.User
import com.varun.login.view.activity.admin.Dashboard
import com.varun.login.viewModel.UserViewModel

class FormSecond : AppCompatActivity() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_second)

        mUserViewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(UserViewModel::class.java)
    }

    fun writeToDB(view: View) {

        fun professionalInputCheck(degree: String, college: String, gradYear: Editable, branch: String): Boolean = !(TextUtils.isEmpty(degree) || TextUtils.isEmpty(college) || gradYear.isEmpty() || TextUtils.isEmpty(branch))


        val degreeView = findViewById<EditText>(R.id.degree)
        val degree = degreeView.text.toString()
        val collegeView = findViewById<EditText>(R.id.college)
        val college = collegeView.text.toString()
        val gradYearView = findViewById<EditText>(R.id.gradYear)
        val gradYear = gradYearView.text
        val branchView = findViewById<EditText>(R.id.branch)
        val branch = branchView.text.toString()

        if( professionalInputCheck(degree, college, gradYear, branch) ) {
            //Get INTENTS
            val intent = intent
            val firstName = intent.getStringExtra(FIRSTNAME)
            val lastName = intent.getStringExtra(LASTNAME)
            val emailAddress = intent.getStringExtra(EMAIL)
            val phone = intent.getStringExtra(PHONE)

            val user = User(
                uid = null,
                firstName = firstName,
                lastName = lastName,
                phone = phone,
                email = emailAddress,
                degree = degree,
                college = college,
                gradYear = Integer.parseInt(gradYear.toString()),
                branch =  branch
            )
            mUserViewModel.addUser(user)
            Toast.makeText(applicationContext, "Data Written", Toast.LENGTH_SHORT).show()
            val nextIntent = if(intent.getStringExtra(ADMIN_LOGGED_IN) == "logged in")
                Intent(this, Dashboard::class.java)
            else
                Intent(this, MainActivity::class.java)
            startActivity(nextIntent)
        }
        else
            Toast.makeText(applicationContext, "Fill all Data Fields", Toast.LENGTH_SHORT).show()
    }
}