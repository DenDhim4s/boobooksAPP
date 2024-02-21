package com.example.e_library

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Login : AppCompatActivity() {

    private lateinit var registerTextView: TextView
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //login To register
        registerTextView = findViewById(R.id.register2)
        registerTextView.setOnClickListener {
            navigateToRegisterPage()
        }
        //login To homepage
        buttonLogin = findViewById(R.id.button_login)
        buttonLogin.setOnClickListener {
            navigateToHomeActivity()
        }
    }

    //login To register
    private fun navigateToRegisterPage() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    //login To homepage
    private fun navigateToHomeActivity() {
        val intent = Intent(this, Main2Activity::class.java)
        startActivity(intent)
        finish()
    }
}