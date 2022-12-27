package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_quizfrnt.*

class quizfrnt : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizfrnt)

        btnc.setOnClickListener {
            val intent = Intent(this,viewlist::class.java)
            startActivity(intent)
        }

        btnp.setOnClickListener {
            val i = Intent(this,QuizQuestionActivity::class.java)
            startActivity(i)

        }
    }
}