package com.miu.walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.miu.walmart.UserRepository.UserRepository
import kotlinx.android.synthetic.main.activity_register_aactivity.*

class RegisterActivity : AppCompatActivity() {
    val userRepo : UserRepository = UserRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_aactivity)
        accountCreatedbtn.setOnClickListener {
            accountCreate()
        }
    }
    fun accountCreate(){
        var firstName = firstNametxt.text!!.toString()
        var lastName =  lastNametxt.text!!.toString()
        var email =  emailTxt.text!!.toString()
        var password = passwordTxt.text!!.toString()

        if(firstName!=null && lastName!=null && email!= null && password!=null){
            userRepo.createUser(firstName, lastName, email, password)
            Toast.makeText(this, "Account created successfully", Toast.LENGTH_LONG).show()
            Toast.makeText(this,UserRepository.users.size.toString(),Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Invalid details", Toast.LENGTH_LONG).show()

        }


        var user :User = User(firstName, lastName, email, password)
       // var createdUser : User =

    }

}