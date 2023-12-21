package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var height:TextView
    private lateinit var weight:TextView
    private lateinit var male:RadioButton
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        height = findViewById(R.id.editTextText)
        weight = findViewById(R.id.editTextText2)
        male = findViewById(R.id.radioButton)
        button = findViewById(R.id.button)


        button.setOnClickListener {
            if (height.text.isNotEmpty() && weight.text.isNotEmpty()) {
                    val intent = Intent(this,MainActivity2::class.java)
                    intent.putExtra("height",height.text.toString().toFloat())
                    intent.putExtra("weight",weight.text.toString().toFloat())
                    intent.putExtra("sex",male.isChecked)
                    startActivity(intent)
            }
        }

    }
}