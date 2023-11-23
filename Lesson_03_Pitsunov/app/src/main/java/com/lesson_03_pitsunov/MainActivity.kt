package com.lesson_03_pitsunov

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.noConstraintsActivityButton).setOnClickListener {
            val intent = Intent(this, LayoutActivity::class.java)
            intent.putExtra("layout", R.layout.activity_no_constraints)
            startActivity(intent)
        }

        findViewById<Button>(R.id.constraintsActivityButton).setOnClickListener {
            val intent = Intent(this, LayoutActivity::class.java)
            intent.putExtra("layout", R.layout.activity_constraints)
            startActivity(intent)
        }
    }
}