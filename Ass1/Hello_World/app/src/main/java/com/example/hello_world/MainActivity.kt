package com.example.hello_world

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

const val EXTRA_MESSAGE = "com.example.hello_world.EXAMPLE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //Called when Button is clicked
    fun sendMessage(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        val message = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    fun toHappyCatto(view: View){
        val intent = Intent(this ,CattoHappy::class.java)
        startActivity(intent)
    }

    fun toSadCatto(view: View){
        startActivity(Intent(this, CattoSad::class.java))
    }

    fun toDoggoBitesDust(view: View){
        startActivity(Intent(this, DoggoBitesDust::class.java))
    }
}