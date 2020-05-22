package com.example.mykotlinapp

class UsersData {
    var users = arrayListOf(User("OliviaV@gmail.com", "Olivia", "Volkova", "Qwerty123"),
        User("Ivanov14@yandex.ru", "Vladislav","Ivanov", "Qwerty123"))


    fun contains(email:String):Boolean{
        for (i in 0 until users.size) {
            if (email.equals(users[i].email)) {
                return true
            }
        }
        return false
    }

    fun getUser(email: String):User?{
        for (i in 0 until users.size) {
            if (email.equals(users[i].email)) {
                return users[i]
            }
        }
        return null
    }
}