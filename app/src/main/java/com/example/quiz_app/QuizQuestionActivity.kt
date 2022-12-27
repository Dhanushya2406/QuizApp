package com.example.quiz_app

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var selectedAnswer: Int = 0
    val userSelectedAns = ArrayList<Int>()
    val myMap: MutableMap<Int, Int> = HashMap()
    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionList = Constants.getQuestions()
        setQuestion()
        option_one.setOnClickListener(this)
        option_two.setOnClickListener(this)
        option_three.setOnClickListener(this)
        option_four.setOnClickListener(this)
        btn_Submit.setOnClickListener(this)
        btn_Prev.setOnClickListener(this)
    }

    private fun setQuestion(){

        val question: Question? = mQuestionList!![mCurrentPosition -1]
        defaultOptionsView()

        if (mCurrentPosition == mQuestionList!!.size){
            btn_Submit.text = "FINISH"
        }else{
            btn_Submit.text = "CONFIRM"
        }

        progressBar.progress = mCurrentPosition
        progress.text = "$mCurrentPosition" + "/" + progressBar.max

        LblQues.text = question!!.question
        option_one.text = question.OptionOne
        option_two.text = question.Optiontwo
        option_three.text = question.Optionthree
        option_four.text = question.Optionfour
    }
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0,option_one)
        options.add(1,option_two)
        options.add(2,option_three)
        options.add(3,option_four)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,R.drawable.option_border
            )
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.option_one -> {
                selectedOptionView(option_one, 1)
            }
            R.id.option_two -> {
                selectedOptionView(option_two, 2)
            }
            R.id.option_three -> {
                selectedOptionView(option_three, 3)
            }
            R.id.option_four -> {
                selectedOptionView(option_four, 4)
            }
            R.id.btn_Submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            userSelectedAns.clear()
                            var intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.CoorectAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border)
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(question.CoorectAnswer, R.drawable.correct_option_border)
                    //answer
                    myMap[question.id] = mSelectedOptionPosition

                    if (mCurrentPosition == mQuestionList!!.size) {
                        btn_Submit.text = "FINISH"
                    } else {
                        btn_Submit.text = "NEXT"
                    }
                    mSelectedOptionPosition = 0

                }
            }
            R.id.btn_Prev ->{
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition--
                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                         setQuestion()
                            for (i in 0..myMap.size){
                                if (i == mCurrentPosition){
                                    selectedAnswer = myMap[i]!!
                                }
                            }
                            answerView(selectedAnswer, R.drawable.selected_ans_option_border)
                        }
                    }
                }
            }

        }
    }
    private fun answerView(answer: Int, drawableView: Int){
       when(answer){
           1 ->{
               option_one.background = ContextCompat.getDrawable(this,drawableView)
           }
           2 ->{
               option_two.background = ContextCompat.getDrawable(this,drawableView)
           }
           3 ->{
               option_three.background = ContextCompat.getDrawable(this,drawableView)
           }
           4 ->{
               option_four.background = ContextCompat.getDrawable(this,drawableView)
           }
       }
    }


    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int ){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,R.drawable.selected_option_border
        )
    }
}