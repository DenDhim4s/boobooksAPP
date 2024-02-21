package com.example.e_library

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window

class MainActivity : AppCompatActivity() {

    private lateinit var loginTextView: TextView
    private lateinit var buttonRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //register To login
        loginTextView = findViewById(R.id.login2)
        loginTextView.setOnClickListener {
            navigateToLoginPage()
        }

        buttonRegister= findViewById(R.id.button_register)
        buttonRegister.setOnClickListener {
            navigateToRegisterPage()
        }

        //pop up
        val showPopupButton: Button = findViewById(R.id.button_register)
        showPopupButton.setOnClickListener {
            showCustomDialog()
        }
    }

    //register To login
    private fun navigateToLoginPage() {
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }

    //pop up
    private fun navigateToRegisterPage() {
        val intent = Intent(this, PopUpRegister::class.java)
        startActivity(intent)
    }

    private fun showCustomDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.activity_pop_up_register)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val LoginButton: Button = dialog.findViewById(R.id.button_login)
        LoginButton.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        dialog.show()
    }
}
