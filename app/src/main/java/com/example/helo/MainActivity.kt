package com.example.helo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnbutton.setOnClickListener() {
            var Name = etName.text.toString()
            var password = etPassword.text
            Toast.makeText(baseContext, Name, Toast.LENGTH_LONG).show()



        }
        btnLogin.setOnClickListener() {
            var name = et.name.toString()
            var password = etPassword.text
            Toast.makeText(baseContext, name, Toast.LENGTH_LONG).show()

        }
}