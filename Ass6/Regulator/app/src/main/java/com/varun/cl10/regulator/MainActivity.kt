package com.varun.cl10.regulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ToggleButton
import com.google.android.material.slider.Slider
import android.view.animation.Animation

import android.view.animation.RotateAnimation

class MainActivity : AppCompatActivity() {

    private var speed:Float = 50F
    private lateinit var fan:ImageView
    private var toggle:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fan = findViewById(R.id.img_fan)

        val toggle: ToggleButton = findViewById(R.id.toggle_fan)
        toggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                this.toggle = true
                setFanSpeed(toggle = this.toggle, speed = this.speed)
            } else {
                this.toggle = false
                setFanSpeed(toggle = this.toggle, speed = this.speed)
            }
        }

        val slider:Slider = findViewById(R.id.slider_fan)
        slider.addOnChangeListener { _, value, _ ->
            speed = value
            setFanSpeed(toggle = this.toggle, speed = this.speed)
        }
    }

    private fun setFanSpeed(toggle:Boolean, speed:Float){
        fun speedToDuration(speed: Float): Long {
            return if (speed == 0F) 0
            else (100F / speed).toLong()
        }
        var speed:Float = speed
        if (!toggle)
            speed = 0F
        val animation = RotateAnimation(0F, 720F,
            Animation.RELATIVE_TO_SELF,0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        animation.duration = speedToDuration(speed)*1000
        animation.repeatCount = Animation.INFINITE
        fan.animation = animation
        fan.startAnimation(animation)
    }

}