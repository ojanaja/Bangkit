package com.example.aplikasiandroidsederhana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasiandroidsederhana.course.Course
import com.example.aplikasiandroidsederhana.course.CourseAdapter
import com.example.aplikasiandroidsederhana.course.CourseData

class MainActivity : AppCompatActivity() {
    private lateinit var rvCourse: RecyclerView
    private var list: ArrayList<Course> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title= "Course"

        rvCourse= findViewById(R.id.recyclerview)
        rvCourse.setHasFixedSize(true)

        list.addAll(CourseData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvCourse.layoutManager = LinearLayoutManager(this)
        val courseAdapter = CourseAdapter(this, list)
        rvCourse.adapter = courseAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.miCompose -> {
                val iAbout = Intent(this@MainActivity,
                    About::class.java)
                startActivity(iAbout)
            }
        }
    }
}