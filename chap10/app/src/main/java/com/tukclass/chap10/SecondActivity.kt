package com.tukclass.chap10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)

        val btnReturn1 = findViewById<Button>(R.id.btnReturn1)
        btnReturn1.setOnClickListener {
            finish()
        }
    }
}
