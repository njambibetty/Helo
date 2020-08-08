package com.example.helo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.row_courses_item.*
import com.example.helo.CoursesRecyclerViewAdapter as CoursesRecyclerViewAdapter1



data class Courses(val course_id: Int, val course_name: String, val course_code: Int, val instructor:String, val description:String)


class CourseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        rvCourses.LayoutManager= LinearLayoutManager(baseContext)
        val coursesRecyclerViewAdapter = CoursesRecyclerViewAdapter1(coursesList = listOf(

            Courses(334,"Flutter",456,"George","Android development"),
            Courses(788,"C#",456,"Nandy","Arduino"),
            Courses(133,"Python",242,"Ohio","AI"),
            Courses(466,"Ruby",465,"Linda","Ruby on rails"),
            Courses(457,"React-Native",377,"Joyce","Android development"),
            Courses(568,"Javascript",567,"Sharon","Front-end Web"),
            Courses(570,"Django",130,"Gabriel","Framework"),
            Courses(578,"Php",468,"Katara","Games development"),
            Courses(759,"Kotlin",467,"Lesarge","Android development"),
            Courses(255,"HTML",477,"Holly","UX Development"),
            Courses(358,"C++",466,"Michael","Arduino")


        ))
        rvCourses.adapter= CoursesRecyclerViewAdapter1
    }
}

