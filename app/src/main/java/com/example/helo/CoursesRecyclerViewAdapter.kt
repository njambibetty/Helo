package com.example.helo

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.helo.Courses
import com.example.helo.R
import kotlinx.android.synthetic.main.activity_courses.view.*



class CoursesRecyclerViewAdapter(val coursesList: List<Courses>
) :
    RecyclerView.Adapter<CoursesRecyclerViewAdapter.NamesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NamesViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_courses_item, parent, false)
        return NamesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return coursesList.size
    }


    override fun onBindViewHolder(holder: NamesViewHolder, position: Int) {
        holder.rowView.tvCourses.text = coursesList[position].toString()
    }

    class NamesViewHolder(val rowView: View) : RecyclerView.ViewHolder(rowView)
}