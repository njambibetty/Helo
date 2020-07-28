package com.example.helo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        btnbutton.setOnClickListener{
            var firstName = etFirstName.text.toString()
            var lastName= etlastname.text.toString()
            var email= etEmail.text.toString()
            var phone= etPhone.text.toString()
            var password= etConfirm.text.toString()
            //Toast.makeText(baseContext, lastName, Toast.LENGTH_SHORT.show()
            //Toast.makeText(baseContext, email, Toast.LENGTH_SHORT.show)()
            //Toast.makeText(baseContext, phone, Toast.LENGTH_SHORT.show)()
            //Toast.makeText(baseContext, password, Toast.LENGTH_SHORT.show)()

        }
        }
    }

