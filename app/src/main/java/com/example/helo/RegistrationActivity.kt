package com.example.helo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registration.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart

class Registrationactivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnbutton.setOnClickListener {
            var FirstName = etFirstName.text.toString()
            var LastName = etlastname.text.toString()
            var email = etEmail.text.toString()
            var PhoneNumber = etPhone.text.toString()
            var Password = etPassword.text.toString()
            var ConfirmPassword = etPassword.text.toString()

            var requestBody = MultipartBody.Builder()

                .setType(MultipartBody.FORM)
                .addFormDataPart("first_name", FirstName)
                .addFormDataPart("last_name", LastName)
                .addFormDataPart("email", email)
                .addFormDataPart("phone_number", PhoneNumber)
                .addFormDataPart("password", Password)
                .build()

            //registerUser(requestBody)
            Toast.makeText(baseContext, Password, Toast.LENGTH_LONG).show()


        }
        fun registerUser(requestBody: RequestBody) {
            var apiClient = ApiClient.buildService(ApiInterface::class.java)
            var registrationCall = apiClient.registerStudent(requestBody)
            registrationCall.enqueue(object : Callback<RegistrationResponse> {
                override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<RegistrationResponse>,
                    response: Response<RegistrationResponse>
                ) {
                    if (response.isSuccessful) {
                        Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG)
                            .show()
                        startActivity(Intent(baseContext, MainActivity::class.java))
                    } else {
                        Toast.makeText(
                            baseContext,
                            response.errorBody().toString(),
                            Toast.LENGTH_LONG
                        )
                            .show()
                    }
                }
            })
        }
    }
}