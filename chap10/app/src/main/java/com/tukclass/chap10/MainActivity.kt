package com.tukclass.chap10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val secPage = findViewById<RadioButton>(R.id.secPage)
        val thirdPage = findViewById<RadioButton>(R.id.thirdPage)
        val btnNewActivity = findViewById<Button>(R.id.btnNewActivity)

        btnNewActivity.setOnClickListener {
            if (secPage.isChecked) {
                startActivity(Intent(this, SecondActivity::class.java))
            } else if (thirdPage.isChecked) {
                startActivity(Intent(this, ThirdActivity::class.java))
            }
        }
    }
}