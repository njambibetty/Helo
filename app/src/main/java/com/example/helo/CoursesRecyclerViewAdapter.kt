package com.example.helo

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.helo.Courses
import com.example.helo.R

abstract class CoursesRecyclerViewAdapter (
    val courses:List<CoursesRecyclerViewAdapter>):
    AppCompatActivity<CoursesRecyclerViewAdapter.CoursesViewHolder>(){
    abstract override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CoursesRecyclerViewAdapter.CoursesViewHolder (

    LayoutInflater.from(parent.context).inflate(R.layout.item_courses,parent,false)
    )
    override fun getItemCount() = courses.size

    override fun onBindViewHolder(
        holder: CoursesRecyclerViewAdapter.CoursesViewHolder,
        position: Int) {
        val courses = courses[position]
        holder.itemView.id.text = courses.id
        holder.itemView.name.text = courses.name
        holder.itemView.code = courses.code
        holder.itemView.id.instructor = courses.instructor
        holder.itemView.description = courses.description
    }

    class CoursesViewHolder ( View: View) : RecyclerView.ViewHolder(view)

}

)
}