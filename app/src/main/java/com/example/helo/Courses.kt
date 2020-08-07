package com.example.helo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Courses : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
        val courses = listOf(
                courses("4536", "Ruby", "33", "Monte", "Ruby on rails")
                courses("5674", "Php", "30", "Carlo", "This is PHP")
                courses("4732", "HTML", "38", "Monique", "Web development")
                courses("4698", "Flutter", "34", "James", "Android development")
                courses("5080", "Python", "31", "James", "Game development")
                courses("4536", "Java", "33", "Monte", "Ai")
                courses("4536", "Javascript", "33", "zuzu", "Front-end web")
                courses("4536", "C#", "28", "Else", "Arduino")
                courses("4536", "Kotlin", "22", "Freia", "Ruby on rails")
                courses("4536", "Flask", "30", "Frey", "Ruby on rails")

            )
                tvCourses.adapter = coursesRecyclerViewAdapter 
    }
}

private operator fun <E> List<E>.invoke(e: E, e1: E, e2: E, e3: E, e4: E) {

}
