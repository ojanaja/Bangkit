package com.example.aplikasiandroidsederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val actionbar = supportActionBar
        actionbar!!.title = "Profile"
        actionbar.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_about)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}