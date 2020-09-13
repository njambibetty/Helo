package com.example.helo.Activities

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Toast
import com.example.helo.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvRegistar.setOnClickListener{
            val intent=Intent(baseContext,Registrationactivity::class.java)
            startActivity(intent)
        }
        btnbutton.setOnClickListener() {
            var Name = etName.text.toString()
            var password = etPhone.text.toString()
            var error = false



            if(Name.isBlank() || Name.isEmpty()){
                error = true
                etName.error="Username  is required"
            }
            if(password.isBlank() || password.isEmpty()){
                error = true
                etPhone.error="Password is required"
            }

            progressBar.max=3000
            val currentProgress=900
            ObjectAnimator.ofInt(progressBar,"progress",currentProgress)
                .setDuration(2000)
                .start()

            var requestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("email", Name)

                .addFormDataPart("password", password)
                .build()
            loginStudents(requestBody)
            Toast.makeText(baseContext, Name, Toast.LENGTH_LONG).show()


        }
}
    fun loginStudents(requestBody: RequestBody) {
        val apiClient =
            ApiClient.buildService(LoginApiInterface::class.java)
        val loginCall = apiClient.loginStudents(requestBody)
        loginCall.enqueue(object : Callback<LoginRespose.LoginResponse> {
            override fun onFailure(call: Call<LoginRespose.LoginResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                progressBar.visibility = View.GONE
            }

            override fun onResponse(
                call: Call<LoginRespose.LoginResponse>,
                response: Response<LoginRespose.LoginResponse>
            ) {
                if (response.isSuccessful) {
                    progressBar.visibility = View.GONE

                    Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG)
                        .show()
                    var accessToken = response.body()?.accessToken
                    var sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
                    var editor = sharedPreferences.edit()
                    editor.putString("ACCESS_TOKEN_KEY", accessToken)
                    editor.apply()
                    val intent = Intent(baseContext, CoursesActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(
                        baseContext,
                        response.errorBody().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        })
    }
}
