package com.lesson_01_pitsunov

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import java.util.TreeSet


class MainActivity : AppCompatActivity() {
<<<<<<< HEAD
    private var students: TreeSet<String> = TreeSet<String>()

=======
>>>>>>> 855f3571098986938cf7f2ea51174b925e10a1f3
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.treeSetActivityButton).setOnClickListener {
            val intent = Intent(this, TreeSetActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.hashMapActivityButton).setOnClickListener {
            val intent = Intent(this, HashMapActivity::class.java)
            startActivity(intent)
        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 855f3571098986938cf7f2ea51174b925e10a1f3
