package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class viewlist : AppCompatActivity() {

    private lateinit var addsBtn: FloatingActionButton
    private lateinit var recy: RecyclerView
    private lateinit var userList:ArrayList<UserData>
    private lateinit var UserAdapter:MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewlist)

        userList= ArrayList()

        addsBtn = findViewById(R.id.addingBtn)
        recy = findViewById(R.id.mRecycler)
        UserAdapter = MyAdapter(this,userList)
        recy.layoutManager= LinearLayoutManager(this)
        recy.adapter=UserAdapter

        addsBtn.setOnClickListener {
            addInfo()
        }
    }

    private fun addInfo(){
        val inflter = LayoutInflater.from(this)
        val v= inflter.inflate(R.layout.activity_mcq,null)

        val Questions = v.findViewById<EditText>(R.id.txtques)
        val option1 = v.findViewById<EditText>(R.id.txtopt1)
        val option2 = v.findViewById<EditText>(R.id.txtopt2)
        val option3 = v.findViewById<EditText>(R.id.txtopt3)
        val option4 = v.findViewById<EditText>(R.id.txtopt4)
        val option5 = v.findViewById<EditText>(R.id.txtopt5)

        val addDialog = AlertDialog.Builder(this)
        addDialog.setView(v)
        addDialog.setPositiveButton("OK"){
            dialog,_->
            val Ques1 = Questions.text.toString()
            val O1 = option1.text.toString()
            val O2 = option2.text.toString()
            val O3 = option3.text.toString()
            val O4 = option4.text.toString()
            val O5 = option5.text.toString()

            userList.add(UserData("Question: $Ques1","Option 1: $O1","Option 2: $O2","Option 3: $O3", "Option 4: $O4","Answer : $O5"))
            UserAdapter.notifyDataSetChanged()
            Toast.makeText(this,"Adding Questions Successfully",Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel"){
                dialog,_->
            dialog.dismiss()
            Toast.makeText(this,"Cancel",Toast.LENGTH_SHORT).show()
        }
        addDialog.create()
        addDialog.show()
    }
}