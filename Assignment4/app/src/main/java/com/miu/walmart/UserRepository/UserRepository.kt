package com.miu.walmart.UserRepository

import com.miu.walmart.User

class UserRepository {
  companion object{
      val users : MutableList<User> =
          mutableListOf(
              User("Regina", "Kandekere", "rkandekere@test.com","123"),
            User("Racheal","Aitaru","raitaru@test.com","345"),
            User("Zein","Samira","zsamira@test.com","567"),
            User("Gordon","Kisakye","gkisakye@test.com","789"),
            User("Fahad","Makabugo","fmakabugo@test.com","901"),
            User("Paul","Kigozi","pkigozi@test.com","135"),
              User("Ben","Kigozi","ben@test.com","13")
          )
  }

    var userRepository : UserRepository?=  null

    fun createRepository() : UserRepository{
        if(userRepository == null){
            userRepository = UserRepository()
        }
    return userRepository as UserRepository
    }
    fun createUser(firstName:String, lastName:String, email:String, password:String){
        var user :User = User(firstName, lastName, email, password)
        users.add(user)
    }
    fun userValidation(name : String, password: String): List<User>{
        val persons : List<User>
        persons = users.filter {
                user ->  user.userName.equals(name) && user.password.equals(password)
        }
        return persons
    }

}