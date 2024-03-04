package com.example.aplikasiandroidsederhana.course

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.aplikasiandroidsederhana.R

class CourseAdapter(private val context: Context, private val listCourse: List<Course>) :
    RecyclerView.Adapter<CourseAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recycler_view, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listCourse.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val course = listCourse[position]

        Glide.with(context) // Use context directly
            .load(course.photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = course.name
        holder.tvRate.text = course.rate

        holder.itemView.setOnClickListener {
            val intent = Intent(context, CourseDetail::class.java).apply {
                putExtra(CourseDetail.EXTRA_RATE, course.rate)
                putExtra(CourseDetail.EXTRA_NAME, course.name)
                putExtra(CourseDetail.EXTRA_PHOTO, course.photo)
                putExtra(CourseDetail.EXTRA_DETAIL, course.detail)
                putExtra(CourseDetail.EXTRA_OVERVIEW, course.overview)
            }
            context.startActivity(intent)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvRate: TextView = itemView.findViewById(R.id.tv_item_rate)
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}
