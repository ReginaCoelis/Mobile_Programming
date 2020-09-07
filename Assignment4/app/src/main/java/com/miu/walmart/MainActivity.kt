package com.miu.walmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.miu.walmart.UserRepository.UserRepository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_shopping.*

class MainActivity : AppCompatActivity() {
    val userRepo : UserRepository = UserRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        signInbtn.setOnClickListener {
            signIn()
        }
        createAccntbtn.setOnClickListener {
            createAccount()
        }
    }
    fun signIn(){
    var persons: List<User> =   userRepo.userValidation(emaiVieweditTxt.text.toString(), passEditTxt.text.toString())
        Log.d("USERS",persons.toString())
       // Toast.makeText(this, userRepo.getExample().size.toString(), Toast.LENGTH_LONG).show()
        if(persons.size!=0){
            var intent : Intent = Intent(this, ShoppingActivity::class.java)
            intent.putExtra("userName",persons[0].userName )
           this.startActivity(intent)
        } else{
            Toast.makeText(this, "Incorrect UserName or Password", Toast.LENGTH_LONG).show()
        }
    }

    fun createAccount(){
        var intent2 : Intent = Intent(this, RegisterActivity::class.java)
        this.startActivity(intent2)
    }

}