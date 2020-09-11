package com.example.helo.Activities

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.helo.*

import kotlinx.android.synthetic.main.activity_courses2.*
import kotlinx.android.synthetic.main.activity_registration.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses2)
        progressBar.max=1000
        val currentProgress=600
        ObjectAnimator.ofInt(progressBar,"progress",currentProgress)
            .setDuration(20000)
            .start()

        fetchCourses()

//        var courseList = listOf<Course>(
//            Course("564", "Flutter", "347", "Zuko", "Android Development"),
//            Course("859", "React-Native", "282", "Aang", "Android Development"),
//            Course("479", "C++", "154", "Joyce", "Arduino"),
//            Course("755", "React", "745", "Katara", "Web Development"),
//            Course("752", "Django", "726", "Lesarge", "Web Development"),
//            Course("789", "Kotlin", "257", "John Owuor", "Android Development"),
//            Course("725", "Python", "789", "John Mwai", "AI")
//
//
//
//        )
//        rvCourses.layoutManager = LinearLayoutManager(baseContext)
//        rvCourses.adapter = CoursesRecyclerViewAdapter(courseList)
    }
    fun fetchCourses() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val accessToken = sharedPreferences.getString("ACCESS_TOKEN_KEY", "")

        val apiClient =
            ApiClient.buildService(ApiInterface::class.java)
        val coursesCall = apiClient.getCourses("Bearer " + accessToken)
        coursesCall.enqueue(object : Callback<CoursesResponse> {
            override fun onFailure(call: Call<CoursesResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<CoursesResponse>,
                response: Response<CoursesResponse>
            ) {
                if (response.isSuccessful) {
                    var courseList = response.body()?.courses as List<Course>
                    var coursesAdapter =
                        CoursesRecyclerViewAdapter(courseList)
                    rvCourses.layoutManager = LinearLayoutManager(baseContext)
                    rvCourses.adapter = coursesAdapter
                } else {
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }
}