package com.example.quiz_app

data class Question(
    val id: Int,
    val question : String,
    val OptionOne : String,
    val Optiontwo : String,
    val Optionthree : String,
    val Optionfour : String,
    val CoorectAnswer : Int
)