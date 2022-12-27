package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility =View.SYSTEM_UI_FLAG_FULLSCREEN
        btn_Start.setOnClickListener {
           if(txtname.text.toString().isEmpty()){
               Toast.makeText(this, "Please enter your name",Toast.LENGTH_SHORT).show()
           }else{
               val intent = Intent(this,quizfrnt::class.java)
               intent.putExtra(Constants.USER_NAME,txtname.text.toString())
               startActivity(intent)
               finish()
           }
        }
    }
}