package com.example.helo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_courses2.*


class CoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses2)

        var courseList = listOf<Course>(
            Course("564", "Flutter", "347", "Zuko", "Android Development"),
            Course("859", "React-Native", "282", "Aang", "Android Development"),
            Course("479", "C++", "154", "Joyce", "Arduino"),
            Course("755", "React", "745", "Katara", "Web Development"),
            Course("752", "Django", "726", "Lesarge", "Web Development"),
            Course("789", "Kotlin", "257", "John Owuor", "Android Development"),
            Course("725", "Python", "789", "John Mwai", "AI")



        )
        rvCourses.layoutManager = LinearLayoutManager(baseContext)
        rvCourses.adapter = CoursesRecyclerViewAdapter(courseList)
    }
}