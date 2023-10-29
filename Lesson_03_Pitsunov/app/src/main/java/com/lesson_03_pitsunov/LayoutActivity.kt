package com.lesson_03_pitsunov

import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.appbar.MaterialToolbar

class LayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(intent.getIntExtra("layout", R.layout.activity_constraints))

        val user: User = User()
        findViewById<TextView>(R.id.cardNumberTextView).text = buildString {
            append("Карта №")
            append(user.cardNumber)
        }
        findViewById<TextView>(R.id.roleTextView).text = user.role

        val nameBlock: RelativeLayout = findViewById(R.id.nameTextBlock)
        findViewById<TextView>(R.id.titleTextView).text = "Имя"
        nameBlock.findViewById<TextView>(R.id.contentTextView).text = user.name

        val surnameBlock: RelativeLayout = findViewById(R.id.surnameTextBlock)
        surnameBlock.findViewById<TextView>(R.id.titleTextView).text = "Фамилия"
        surnameBlock.findViewById<TextView>(R.id.contentTextView).text = user.surname

        val emailBlock: RelativeLayout = findViewById(R.id.emailTextBlock)
        emailBlock.findViewById<TextView>(R.id.titleTextView).text = "E-mail"
        emailBlock.findViewById<TextView>(R.id.contentTextView).text = user.email

        val loginBlock: RelativeLayout = findViewById(R.id.loginTextBlock)
        loginBlock.findViewById<TextView>(R.id.titleTextView).text = "Логин"
        loginBlock.findViewById<TextView>(R.id.contentTextView).text = user.login

        val regionBlock: RelativeLayout = findViewById(R.id.regionTextBlock)
        regionBlock.findViewById<TextView>(R.id.titleTextView).text = "Ваш регион"
        regionBlock.findViewById<TextView>(R.id.contentTextView).text = user.region
        regionBlock.findViewById<ImageButton>(R.id.textViewBlockButton).visibility = VISIBLE
        regionBlock.findViewById<ImageButton>(R.id.textViewBlockButton).setOnClickListener {
            Toast.makeText(this, "Нельзя сбежать из Саратова", Toast.LENGTH_SHORT).show()
        }

        findViewById<MaterialToolbar>(R.id.toolbar).setNavigationOnClickListener {
            Toast.makeText(this, "Стрелочка", Toast.LENGTH_SHORT).show()
        }

        findViewById<MaterialToolbar>(R.id.toolbar).setOnMenuItemClickListener {
            Toast.makeText(this, "Карандашик", Toast.LENGTH_SHORT).show()
            true
        }

        findViewById<Button>(R.id.logoutButton).setOnClickListener {
            Toast.makeText(this, "НЕ УХАДИ", Toast.LENGTH_SHORT).show()
        }
    }
}