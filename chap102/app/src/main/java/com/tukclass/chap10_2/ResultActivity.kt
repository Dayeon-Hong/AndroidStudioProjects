package com.tukclass.chap10_2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setIcon(R.drawable.pici_icon)
        title = "투표 결과"

        // 앞 화면에서 보낸 투표 결과 값을 받는다.
        var intent = intent
        var voteResult = intent.getIntArrayExtra("VoteCount")
        var imageName = intent.getStringArrayExtra("ImageName")

        // 9개의 TextView, RatingBar 객체배열
        var tv = imageName?.let { arrayOfNulls<TextView>(it.size) }
        var rbar = imageName?.let { arrayOfNulls<RatingBar>(it.size) }

        // 9개의 TextView, RatingBar ID 배열
        var tvID = arrayOf(R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9)
        var rbarID = arrayOf(R.id.rtb1, R.id.rtb2, R.id.rtb3, R.id.rtb4, R.id.rtb5, R.id.rtb6, R.id.rtb7, R.id.rtb8, R.id.rtb9)

        val imageFileId = arrayOf(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4,
            R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9)

        // TextView, RatingBar 개체 찾기.
        for (i in voteResult!!.indices) {
            tv?.set(i, findViewById<TextView>(tvID[i]))
            rbar?.set(i, findViewById<RatingBar>(rbarID[i]))
        }

        // 각 TextVeiw 및 RatingBar에 넘겨 받은 값을 반영.
        for (i in voteResult.indices) {
            tv?.get(i)!!.setText(imageName?.get(i))
            rbar?.get(i)!!.setRating(voteResult[i].toFloat())

        }

        var imgName: TextView = findViewById(R.id.imgName)
        var mainimg: ImageView = findViewById(R.id.mainimg)
        var max = -1
        var index = 0

        for(i in voteResult.indices){
            if(max < voteResult[i]){
                max = voteResult[i]
                index = i
            }
        }

        imgName.text = imageName?.get(index)
        mainimg.setImageResource(imageFileId[index])

        var btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            finish()
        }

    }
}