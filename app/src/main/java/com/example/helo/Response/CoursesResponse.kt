package com.example.helo.Response

import com.example.helo.Course
import com.google.gson.annotations.SerializedName

data class CoursesResponse(
    @SerializedName("courses") var courses: List<Course>
)