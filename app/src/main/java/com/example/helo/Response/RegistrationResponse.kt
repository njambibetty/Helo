package com.example.helo.Response

import com.example.helo.Student
import com.google.gson.annotations.SerializedName

class RegistrationResponse {
    data class RegistrationResponse(
        @SerializedName("message") var message: String,
        @SerializedName("student") var student: Student
    )
}