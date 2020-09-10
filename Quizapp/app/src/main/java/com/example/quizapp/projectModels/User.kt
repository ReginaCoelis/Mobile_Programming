package com.example.quizapp.projectModels

class User(var name:String,var age:Int,var image:Int?){
    val blogs:MutableList<Blog> = mutableListOf()
    val achievements:MutableList<Achievement> = mutableListOf()
    var contact:MyContact?=null
    val skills:MutableList<Skill> = mutableListOf()


    fun addskill(skill:Skill){
        skills.add(skill)
    }

    fun addAchievement(achievement: Achievement){
        achievements.add(achievement)
    }

    fun addBlog(blog: Blog){
        blogs.add(blog)
    }

}