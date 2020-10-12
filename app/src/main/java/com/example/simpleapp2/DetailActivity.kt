package com.example.simpleapp2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val textView = findViewById<TextView>(R.id.textView)
        val title = intent.getStringExtra("title")
        textView.text = title
    }
}