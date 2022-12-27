package com.example.quiz_app

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val c:Context,val userList: ArrayList<UserData>):RecyclerView.Adapter<MyAdapter.UserviewHolder>() {
    inner class UserviewHolder(val v: View) : RecyclerView.ViewHolder(v) {
        var Ques: TextView
        var Opt1: TextView
        var Opt2: TextView
        var Opt3: TextView
        var Opt4: TextView
        var Opt5: TextView
        var mMenus: ImageView

        init {
            Ques = v.findViewById<TextView>(R.id.mQues)
            Opt1 = v.findViewById<TextView>(R.id.btn1)
            Opt2 = v.findViewById<TextView>(R.id.btn2)
            Opt3 = v.findViewById<TextView>(R.id.btn3)
            Opt4 = v.findViewById<TextView>(R.id.btn4)
            Opt5 = v.findViewById<TextView>(R.id.crtanswer)
            mMenus = v.findViewById(R.id.mMenus)
            mMenus.setOnClickListener { popupMenus(it)}

        }
        private fun popupMenus(v: View) {
            val position = userList[adapterPosition]
            val popupMenus = PopupMenu(c, v)
            popupMenus.inflate(R.menu.show_menu)
            popupMenus.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.editText -> {
                        val v = LayoutInflater.from(c).inflate(R.layout.activity_mcq, null)
                        val name = v.findViewById<EditText>(R.id.txtques)
                        val opt1 = v.findViewById<EditText>(R.id.txtopt1)
                        val opt2 = v.findViewById<EditText>(R.id.txtopt2)
                        val opt3 = v.findViewById<EditText>(R.id.txtopt3)
                        val opt4 = v.findViewById<EditText>(R.id.txtopt4)
                        val opt5 = v.findViewById<EditText>(R.id.txtopt5)
                        AlertDialog.Builder(c)
                            .setView(v)
                            .setPositiveButton("OK") { dialog, _ ->
                                position.Question = name.text.toString()
                                position.Option1 = opt1.text.toString()
                                position.Option2 = opt2.text.toString()
                                position.Option3 = opt3.text.toString()
                                position.Option4 = opt4.text.toString()
                                position.Option5 = opt5.text.toString()

                                notifyDataSetChanged()
                                Toast.makeText(c, "User Information is Edited", Toast.LENGTH_SHORT)
                                    .show()
                                dialog.dismiss()
                            }
                            .setNegativeButton("Cancel") { dialog, _ ->
                                dialog.dismiss()
                            }
                            .create()
                            .show()

                        true
                    }
                    else -> true
                }

            }
            popupMenus.show()
            val popup = PopupMenu::class.java.getDeclaredField("mPopup")
            popup.isAccessible = true
            val menu = popup.get(popupMenus)
            menu.javaClass.getDeclaredMethod("setForceShowIcon",Boolean::class.java).invoke(menu,true)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserviewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.activity_listitem, parent, false)
        return UserviewHolder(v)
    }

    override fun onBindViewHolder(holder: UserviewHolder, position: Int) {
        val newList = userList[position]
        holder.Ques.text = newList.Question
        holder.Opt1.text = newList.Option1
        holder.Opt2.text = newList.Option2
        holder.Opt3.text = newList.Option3
        holder.Opt4.text = newList.Option4
        holder.Opt5.text = newList.Option5
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}

