package com.example.bmi

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.math.roundToLong

class MainActivity2 : AppCompatActivity() {

    private lateinit var result:TextView
    private lateinit var suggestion:TextView
    private lateinit var back:Button
    private var bmi : Float = 0.0F

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        result = findViewById(R.id.textView6)
        suggestion = findViewById(R.id.textView7)
        back = findViewById(R.id.button2)

        var height = intent.getFloatExtra("height", 0.0F)?.toFloat()
        var weight = intent.getFloatExtra("weight",0.0F)?.toFloat()
        var sex = intent.getBooleanExtra("sex",false)

        if (height != null) {
            if (weight != null) {
                bmi = ((weight/(height*height)))
            }
        }

        result.text = "%.2f".format(bmi)

        back.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        when(sex){
            true -> {
                manBmi()
            }
            false -> {
                feBmi()
            }
        }


    }

    @SuppressLint("SetTextI18n")
    private fun manBmi(){
        if (bmi == null){
            result.text = "error"
        }
        if (bmi in 20.0..25.0){
            suggestion.text = "體型很棒喔"
        }
        else if(bmi < 20.0){
            suggestion.text = "您該多吃點"
        }
        else {
            suggestion.text = "您該少吃些，並多多運動"
        }
    }

    private fun feBmi(){
        if (bmi == null){
            result.text = "error"
        }
        if (bmi in 18.0..22.0){
            suggestion.text = "體型很棒喔"
        }
        else if(bmi < 18.0){
            suggestion.text = "您該多吃點"
        }
        else {
            suggestion.text = "您該少吃些，並多多運動"
        }
    }

}