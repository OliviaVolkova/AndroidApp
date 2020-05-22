package com.example.mykotlinapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var preference: SharedPreferences
    val prefName = "myPref"
    val isAutho = "isAutho"
    val email = "email"
    val data = UsersData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preference = getSharedPreferences(prefName, AppCompatActivity.MODE_PRIVATE)
        if(preference.contains(isAutho) && preference.getBoolean(isAutho,false)){
            openSecondActivity()
        }
    }

    fun openSecondActivity(){
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    public fun clickFirst(view: View){
        val emailReg = Regex("[A-Za-z0-9]*@[a-zA-Z]+.[a-z]{2,10}")
        val pR1 =  Regex("[A-Z]")
        val pR2 = Regex("[a-z]")
        val pR3 = Regex("[0-9]")
        var mail = emailMain.text.toString()
        var password = passwordMain.text.toString()
        if(emailReg.matches(mail) && pR1.containsMatchIn(password) &&
                            pR2.containsMatchIn(password) && pR3.containsMatchIn(password) && password.length>=6){
            if(data.contains(mail)){
              if(data.getUser(mail)!!.password.equals(password)){
                  savePref(mail)
                  openSecondActivity()
              }
              else{
                  Toast.makeText(this, "Неверное имя пользователя или пароль", Toast.LENGTH_SHORT).show()
              }
            }
            else{
                Toast.makeText(this, "Неверное имя пользователя или пароль", Toast.LENGTH_SHORT).show()
            }
        }
        else{
            Toast.makeText(this, "Неправильный формат ввода", Toast.LENGTH_SHORT).show()
        }

    }

    private fun savePref(mail :String){
        val save = preference.edit()
        save.putBoolean(isAutho,true)
        save.putString(email, mail)
        save.apply()
    }
}
