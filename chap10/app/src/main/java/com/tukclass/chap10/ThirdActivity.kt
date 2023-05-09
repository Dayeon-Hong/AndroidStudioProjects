package com.tukclass.chap10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third)

        val btnReturn2 = findViewById<Button>(R.id.btnReturn2)
        btnReturn2.setOnClickListener {
            finish()
        }
    }
}
