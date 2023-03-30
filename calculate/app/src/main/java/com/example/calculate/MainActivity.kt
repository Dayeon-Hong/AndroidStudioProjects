package com.example.calculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // 멤버 변수 선언
    lateinit  var edit1: EditText
    lateinit  var edit2: EditText

    lateinit  var btnAdd: Button
    lateinit  var btnSub: Button
    lateinit  var btnMul: Button
    lateinit  var btnDiv: Button

    lateinit  var Result: TextView

    lateinit  var num1: String  // 숫자 1
    lateinit  var num2: String  // 숫자 2
    var result: Int? = null

    // 0~9 숫자 배열
    var numButtons  = ArrayList<Button>(10)

    // 0~9 까지 숫자 버튼 id값
    var btnIDs = arrayOf(R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9)
    var i: Int = 0 // 증가값 용도

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // onCreate() 내부에 작성
        title = "테이블 레이아웃 계산기"

        edit1 = findViewById<EditText>(R.id.Edit1)
        edit2 = findViewById<EditText>(R.id.Edit2)
        btnAdd = findViewById<Button>(R.id.BtnAdd)
        btnSub = findViewById<Button>(R.id.BtnSub)
        btnMul = findViewById<Button>(R.id.BtnMul)
        btnDiv = findViewById<Button>(R.id.BtnDiv)
        Result = findViewById<TextView>(R.id.Result)

        btnAdd.setOnTouchListener { View, MotionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) + Integer.parseInt(num2)
            Result.text = "답 : " + result.toString()
            false
        }

        btnSub.setOnTouchListener { View, MotionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) - Integer.parseInt(num2)
            Result.text = "답 : " + result.toString()
            false
        }

        btnMul.setOnTouchListener { View, MotionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) * Integer.parseInt(num2)
            Result.text = "답 : " + result.toString()
            false
        }

        btnDiv.setOnTouchListener { View, MotionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) / Integer.parseInt(num2)
            Result.text = "답 : " + result.toString()
            false
        }

        // 숫자 계산에 버튼 추가
        for (i in 0..9) {
            numButtons.add(findViewById<Button>(btnIDs[i]))
        }

        for (i in 0..btnIDs.size - 1) {
            numButtons[i].setOnClickListener {
                // 숫자 1, 숫자 2 입력창에 숫자 추가
                if (edit1.isFocused == true) {
                    num1 = edit1.text.toString() + numButtons[i].getText().toString()
                    edit1.setText(num1)
                } else {
                    num2 = edit2.text.toString() + numButtons[i].getText().toString()
                    edit2.setText(num2)

                }
            }
        }


    }}