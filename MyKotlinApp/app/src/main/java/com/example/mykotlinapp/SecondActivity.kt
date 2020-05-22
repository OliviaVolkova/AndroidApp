package com.example.mykotlinapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    lateinit var preference: SharedPreferences
    val prefName = "myPref"
    val isAutho = "isAutho"
    val email = "email"
    val data = UsersData()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        preference = getSharedPreferences(prefName, AppCompatActivity.MODE_PRIVATE)
        var user = data.getUser(preference.getString(email,"")!!)!!
        emailSecond.setText(user.email)
        firstNameSecond.setText(user.firstName)
        lastNameSecond.setText(user.lastName)

    }

    fun exit(view : View){
        preference.edit().putBoolean(isAutho,false).apply()
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)

    }
}
