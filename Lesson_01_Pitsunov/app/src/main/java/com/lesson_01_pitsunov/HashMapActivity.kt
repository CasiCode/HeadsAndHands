package com.lesson_01_pitsunov

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HashMapActivity : AppCompatActivity() {
    private var students: HashMap<Long?, Student> = HashMap<Long?, Student>()

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hashmap)

        findViewById<EditText>(R.id.editText).setOnKeyListener { _, keyCode, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val str: String = findViewById<EditText>(R.id.editText).text.toString()
                val strInParts = str.split(" ")

                try {
                    val student: Student = Student(
                        strInParts[0],
                        strInParts[1],
                        strInParts[2],
                        strInParts[3]
                    )

                    students.put(student.id, student)
                }
                catch (e: IndexOutOfBoundsException) {
                    Toast.makeText(this, "input is not correct", Toast.LENGTH_SHORT).show()
                }

                findViewById<EditText>(R.id.editText).text.clear()
                return@setOnKeyListener true
            }
            false
        }

        findViewById<Button>(R.id.printButton).setOnClickListener {
            val output = buildString {
                students.forEach {
                    append("${it.key.toString()} ${it.value.fieldsToString()}\n")
                }
            }
            findViewById<TextView>(R.id.textView).text = output
        }
    }
}