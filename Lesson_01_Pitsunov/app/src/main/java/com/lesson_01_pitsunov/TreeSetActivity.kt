package com.lesson_01_pitsunov

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import java.util.TreeSet


class TreeSetActivity : AppCompatActivity() {
    private val students: TreeSet<String> = TreeSet<String>()

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_treeset)

        findViewById<Button>(R.id.saveButton).setOnClickListener {
            val input: String = findViewById<EditText>(R.id.editText).text.toString()
            students.add(input)
            findViewById<EditText>(R.id.editText).text.clear()
        }

        findViewById<Button>(R.id.printButton).setOnClickListener {
            val output = buildString {
                students.forEach {
                    append("$it\n")
                }
            }
            findViewById<TextView>(R.id.textView).text = output
        }
    }
}