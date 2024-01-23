package com.example.step06customlistview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DetailActivity : AppCompatActivity() { // extends AppCompatActivity
    //onCreate() 메소드 오버라이드
    override fun onCreate(savedInstanceState: Bundle?) { //Bundle?  nullable type
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        //Detail 액티비티에 전달된 Intent 객체
        val i:Intent = getIntent()  // getIntent() 액티비티의 메소드
        val dto:CountryDto = i.getSerializableExtra("dto") as CountryDto

        //ImageView 의 참조값 얻어오기
        //val imageView = findViewById<ImageView>(R.id.imageView)
        val imageView:ImageView = findViewById(R.id.imageView)
        val textName:TextView = findViewById(R.id.textName)
        val textContent:TextView = findViewById(R.id.textContent)
        //CountryDto 에 있는 정보를 UI 에 출력하기
        imageView.setImageResource(dto.resId)
        //textName.setText(dto.getName())
        textName.text=dto.name
        //textContent.setText(dto.getContent())
        textContent.text=dto.content
        val confirmBtn: Button =findViewById(R.id.confirmBtn)
        //버튼에 클릭 리스너 등록
        confirmBtn.setOnClickListener {
            //액티비티의 finish() 메소드 호출하기
            finish()
        }
    }
}







