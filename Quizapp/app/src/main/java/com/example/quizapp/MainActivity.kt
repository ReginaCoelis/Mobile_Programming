package com.example.quizapp

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.quizapp.dataFactory.UserInstance
import com.example.quizapp.projectModels.*
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalTime
import java.util.*

class MainActivity : AppCompatActivity() {

    var selectedButton:Int?=null

   private  val answerList:MutableList<AnswerModel> = mutableListOf(
        AnswerModel("Which of the below options is not a method of android activity lifecycle?","onAttach()",null),
        AnswerModel("Which of the following is a Kotlin integer data type ?","Int",null)
    )

    val user = UserInstance().getUserInstance()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView1.text = answerList[0].question
        textView2.text = answerList[1].question

        radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            val radioButton = findViewById<RadioButton>(i)
            selectedButton =i
            setAnswer(radioButton.text.toString(),0)
            Toast.makeText(applicationContext,"this is ${radioButton.text}",Toast.LENGTH_SHORT).show()
        }



        checkBox1.setOnClickListener {
            checkBox2.isChecked=false
            checkBox3.isChecked=false
            setAnswer(checkBox1.text.toString(),1)
            Toast.makeText(applicationContext,"this is ${checkBox1.text}",Toast.LENGTH_SHORT).show()
        }

        checkBox2.setOnClickListener {
            checkBox1.isChecked=false
            checkBox3.isChecked=false
            setAnswer(checkBox2.text.toString(),1)
            Toast.makeText(applicationContext,"this is ${checkBox2.text}",Toast.LENGTH_SHORT).show()
        }

        checkBox3.setOnClickListener {
            val checkBox = findViewById<CheckBox>(R.id.checkBox3)
            findViewById<CheckBox>(R.id.checkBox2).isChecked=false
            findViewById<CheckBox>(R.id.checkBox1).isChecked=false
            setAnswer(checkBox3.text.toString(),1)
            Toast.makeText(applicationContext,"this is ${checkBox.text}",Toast.LENGTH_SHORT).show()
        }

        button1.setOnClickListener {
            this.reset()
        }

        button2.setOnClickListener {
            openDialog()
        }

         }

    private fun setAnswer(answer:String,index:Int){
        answerList[index].givenAnswer = answer
    }

    private fun calculateResult():Int{
        var sum =0
        answerList.forEach {
            if(it.answer ==it?.givenAnswer){
                sum+=1
            }
        }
        return sum*50
    }

    private fun reset(){
        if(selectedButton!=null){
            val radioButton = findViewById<RadioButton>(selectedButton as Int)
            radioButton.isChecked=false
            selectedButton=null
        }
        resetList()
        checkBox1.isChecked=false
        checkBox2.isChecked=false
        checkBox3.isChecked=false

    }

    private fun openDialog(){
        val time = Calendar.getInstance().time
        val alertDialog =  AlertDialog.Builder(this)
        alertDialog.setMessage("Congratulations! You submitted on $time , your achieved is : ${calculateResult()} %")
            .setCancelable(false)
            .setNegativeButton("Cancel",DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.dismiss() })
            .setPositiveButton("Ok",DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.dismiss() })

       var alert = alertDialog.create()
        alert.setTitle("Quiz Result")
        alert.show()
    }

    private fun resetList(){
        answerList.forEach {
            it.givenAnswer=null
        }
    }
}
