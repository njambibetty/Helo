package com.example.helo.Response

import com.google.gson.annotations.SerializedName

class LoginRespose {
    data class LoginResponse(
        @SerializedName("access_token")var accessToken:String,
        @SerializedName("message")var message:String

    )
}