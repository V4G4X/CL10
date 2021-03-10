package com.example.hello_world

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class DisplayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val toast_text = "This is a sample Toast"
        val toast_duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, toast_text, toast_duration)
        toast.show()

        // Get message passed by MainActivity as Extra to intent
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }
    }
}