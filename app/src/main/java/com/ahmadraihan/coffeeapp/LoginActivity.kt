package com.ahmadraihan.coffeeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.content.Context as Context1
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val editUsername: TextView = findViewById(R.id.login_username)
        val editPassword: TextView = findViewById(R.id.login_password)
        val btnLogin: Button = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener {
            if (editUsername.text.toString() =="admin"){
                if (editPassword.text.toString() == "admin"){
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    val toast: Toast = Toast.makeText(applicationContext,
                        "Password Salah", Toast.LENGTH_SHORT)
                    toast.show()
                }
            } else {
                val toast: Toast = Toast.makeText(applicationContext,
                    "Username Tidak di Temukan", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }
}