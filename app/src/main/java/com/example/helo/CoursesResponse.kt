package com.example.helo

import com.google.gson.annotations.SerializedName

data class CoursesResponse(
    @SerializedName("courses") var courses: List<Course>
)