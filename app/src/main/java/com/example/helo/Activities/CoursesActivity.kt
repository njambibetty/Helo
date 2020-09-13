package com.example.helo.Activities

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.helo.*
import com.example.helo.API.ApiClient
import com.example.helo.API.ApiInterface
import com.example.helo.Response.CoursesResponse
import database.HeloDatabase

import kotlinx.android.synthetic.main.activity_courses2.*
import kotlinx.android.synthetic.main.activity_registration.*
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class CourseActivity : AppCompatActivity(), CourseItemClickListener {
    lateinit var database: HeloDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses2)
        database = Room.databaseBuilder(baseContext, HeloDatabase::class.java, "hello-db").build()
        fetchCourses()
    }

    fun fetchCourses() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val accessToken = sharedPreferences.getString("ACCESS_TOKEN_KEY", "")

        val apiClient = ApiClient.buildService(ApiInterface::class.java)
        val coursesCall = apiClient.getCourses("Bearer " + accessToken)
        coursesCall.enqueue(object : Callback<CoursesResponse> {
            override fun onFailure(call: Call<CoursesResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                fetchCoursesFromDatabase()
            }

            override fun onResponse(call: Call<CoursesResponse>, response: Response<CoursesResponse>) {
                if (response.isSuccessful) {
                    var courseList = response.body()?.courses as List<Course>
                    Thread {
                        courseList.forEach { course ->
                            database.courseDao().insertCourse(course)
                        }
                    }.start()

                    displayCourses(courseList)
                } else {
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }

    fun fetchCoursesFromDatabase(){
        Thread{
            val courses = database.courseDao().getAllCourses()

            runOnUiThread {
                displayCourses(courses)
            }
        }.start()
    }

    fun displayCourses(courses: List<Course>){
        var coursesAdapter = CoursesRecyclerViewAdapter(courses, this)
        rvCourses.layoutManager = LinearLayoutManager(baseContext)
        rvCourses.adapter = coursesAdapter
    }

    override fun onItemClick(course: Course) {
        //obtain student id from shared preferences
        //courseId = course.courseId
        //make a post request https://github.com/owuor91/registration-api


        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val accessToken = sharedPreferences.getString("ACCESS_TOKEN_KEY", "")
        val studentId = sharedPreferences.getString("STUDENT_ID_KEY", "")
        var courseId = course.courseId

        var requestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("course_id", courseId)
            .addFormDataPart("student_id", studentId!!)
            .build()


        val apiClient = ApiClient.buildService(ApiInterface::class.java)
        val coursesCall = apiClient.registerCourse(requestBody,"Bearer $accessToken")


        coursesCall.enqueue(object : Callback<RegisterCourse> {
            override fun onFailure(call: Call<RegisterCourse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<RegisterCourse>,
                response: Response<RegisterCourse>
            ) {
                if(response.isSuccessful){
                    Toast.makeText(this@CourseActivity, "Registered", Toast.LENGTH_SHORT).show()
                }
            }


        })

    }




}