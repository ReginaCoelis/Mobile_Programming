package com.miu.dinnerdecider

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    val foods: MutableList<String> = mutableListOf("Pizza", "Hamburger", "Mexican", "American", "Chinese")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView.setImageResource(R.drawable.dd_logo)
        addFoodbtn.setOnClickListener {
            addFood()
        }
        decidebtn.setOnClickListener {
            randomFoods()
        }
    }

    private fun addFood(){
        val food = foodText!!.text.toString()
        if (!food.trim().isEmpty()){
            foods.add(food)
            Toast.makeText(this,"Food successfully added!!", Toast.LENGTH_LONG).show()

        } else {
            Toast.makeText(this,"Enter food", Toast.LENGTH_LONG).show()

        }

    }

    private fun randomFoods(){
        var foodIndex = Random.nextInt(0, foods.size)
        foodSelector.text = foods[foodIndex]

    }


}