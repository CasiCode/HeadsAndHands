package com.lesson_02_pitsunov

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.localeButton).setOnClickListener {
            val intent = Intent(this, LocaleActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.layerListButton).setOnClickListener {
            val intent = Intent(this, LayerListActivity::class.java)
            startActivity(intent)
        }
    }
}