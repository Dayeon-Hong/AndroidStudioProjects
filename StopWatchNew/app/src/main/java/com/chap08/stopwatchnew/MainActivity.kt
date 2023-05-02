package com.chap08.stopwatchnew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    private var time = 0 // 시간을 계산하는 변수
    private var timerTask : Timer? = null
    private var isRunning = false
    private var lap = 1

    lateinit var startFab : FloatingActionButton
    lateinit var secTextView : TextView
    lateinit var milliTextView : TextView
    lateinit var labLayout : LinearLayout
    lateinit var labButton: Button
    lateinit var resetFab : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        secTextView = findViewById<TextView>(R.id.secTextView)
        milliTextView = findViewById<TextView>(R.id.milliTextView)
        labLayout = findViewById<LinearLayout>(R.id.lapLayout)
        labButton = findViewById (R.id.lapButton)
        startFab = findViewById<FloatingActionButton>(R.id.startFab)
        resetFab = findViewById<FloatingActionButton>(R.id.resetFab)

        // 시작 일시정지 이벤트 구현
        startFab.setOnClickListener {
            isRunning = !isRunning

            if (isRunning) {
                start()
            } else {
                pause()
            }
        }

//        val textView = TextView(this)
//        textView.text = "글자 "
//        lapLayout.addView(textView, 0)

        // 랩타입 표시
        labButton.setOnClickListener{
            recordLapTime()
        }

        // 초기화 연결 - reset
        resetFab.setOnClickListener {
            reset()
        }

    }

    // 타이머 시작 함수
    private fun start() {
        startFab.setImageResource(R.drawable.baseline_pause_24) // 일시정지 이미지로 변경

        timerTask = timer(period = 10){
            time ++
            val sec = time / 100
            val milli = time % 100
            runOnUiThread{
                secTextView.text = "$sec"
                milliTextView.text = "$milli"
            }
        }
    }

    // 타이머 일시 정지 함수
    private fun pause() {
        startFab.setImageResource(R.drawable.baseline_play_arrow_24) // 시작 이미지로 교
        timerTask?.cancel() // 타이머 취소
    }

    // 랩타임 기록하고 화면에 표시 함수
    private fun recordLapTime() {
        val lapTime = this.time
        val textView = TextView(this)
        textView.text = "$lap LAB : ${lapTime / 100}.${lapTime % 100}"

        // 맨 위에 랩타임 추가
        labLayout.addView(textView, 0) // 리니어 레이아웃에 랩타입 추가
        lap++  //랩타임 번호 증가
    }

    // 타이머 초기화 구현 함수
    private fun reset() {
        timerTask?.cancel()  // 실행중인 타이머 취소

        // 모든 변수 초기화
        time = 0
        isRunning = false
        startFab.setImageResource(R.drawable.baseline_play_arrow_24)
        secTextView.text = "0"
        milliTextView.text = "00"

        // 모든 랩타임을 제거
        labLayout.removeAllViews()
        lap=1
    }


}