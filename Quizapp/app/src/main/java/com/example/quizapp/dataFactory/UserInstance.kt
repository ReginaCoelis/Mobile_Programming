package com.example.quizapp.dataFactory

import android.util.Log
import com.example.quizapp.R
import com.example.quizapp.projectModels.*

class UserInstance {
    private var user:User?=null


    fun getUserInstance():User{
        if(user==null){
            createUser()
        }
        return user as User
    }

    private fun createUser(){
        Log.d("myuser","creating new user")
        user = User("Bendevet",29, R.drawable.ic_launcher_background)
        val contact = MyContact("13 Obosi street","+2348033242484","benbow2005@gmail.com","bernardnwogbo@facbook.com")
        user?.contact = contact
        addUserAchievement(user as User)
        addUserBlogs(user as User)
        addUsersSkill(user as User)
        getUserAchievements(user as User)
    }

    private fun getUserAchievements(user: User){
        user.achievements.forEach {
            Log.d("myuser","$it")
        }
    }

    private fun addUserBlogs(user: User){
        val blogs :List<Blog> = mutableListOf(
            Blog("About me","I'm a developer"),
            Blog("My Vacation","I love Milan"),
            Blog("My Life in Maharishi","We all love Anapuna")
        )
        user.blogs.addAll(blogs)
    }

    private fun addUsersSkill(user: User){
        val skills = mutableListOf(
            Skill("I play basket ball"),
            Skill("Proficient in Java"),
            Skill("Proficient in Kotlin"),
            Skill("Profificent in Dart"),
            Skill("Fullstack web and mobile developer")

        )

        user.skills.addAll(skills)
    }

    private fun addUserAchievement(user: User){
        val achievements = mutableListOf(
            Achievement("I've built 150 android mobile apps and counting"),
            Achievement("Developed complete enterprise software with spring framework"),
            Achievement("Developed complete angular application")

        )
        user.achievements.addAll(achievements)
    }
}