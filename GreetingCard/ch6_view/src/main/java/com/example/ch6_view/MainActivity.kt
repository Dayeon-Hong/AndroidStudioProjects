package com.example.ch6_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText : EditText = findViewById(R.id.editText)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            if(editText.text.toString() == "12345"){
                Toast.makeText(this,"valid", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this,"invalid",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}