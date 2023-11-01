package com.lesson_03_pitsunov

import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class LayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(intent.getIntExtra("layout", R.layout.activity_constraints))

        val user: User = User()
        findViewById<TextView>(R.id.cardNumberTextView).text = buildString {
            append(getString(R.string.card_number_title))
            append(user.cardNumber)
        }
        findViewById<TextView>(R.id.roleTextView).text = user.role

        val nameBlock: RelativeLayout = findViewById(R.id.nameTextBlock)
        findViewById<TextView>(R.id.titleTextView).text = getString(R.string.name_title)
        nameBlock.findViewById<TextView>(R.id.contentTextView).text = user.name

        val surnameBlock: RelativeLayout = findViewById(R.id.surnameTextBlock)
        surnameBlock.findViewById<TextView>(R.id.titleTextView).text = getString(R.string.surname_title)
        surnameBlock.findViewById<TextView>(R.id.contentTextView).text = user.surname

        val emailBlock: RelativeLayout = findViewById(R.id.emailTextBlock)
        emailBlock.findViewById<TextView>(R.id.titleTextView).text = getString(R.string.email_title)
        emailBlock.findViewById<TextView>(R.id.contentTextView).text = user.email

        val loginBlock: RelativeLayout = findViewById(R.id.loginTextBlock)
        loginBlock.findViewById<TextView>(R.id.titleTextView).text = getString(R.string.login_title)
        loginBlock.findViewById<TextView>(R.id.contentTextView).text = user.login

        val regionBlock: RelativeLayout = findViewById(R.id.regionTextBlock)
        regionBlock.findViewById<TextView>(R.id.titleTextView).text = getString(R.string.region_title)
        regionBlock.findViewById<TextView>(R.id.contentTextView).text = user.region
        regionBlock.findViewById<ImageButton>(R.id.textViewBlockButton).visibility = VISIBLE
        regionBlock.findViewById<ImageButton>(R.id.textViewBlockButton).setOnClickListener {
            Toast.makeText(this, getString(R.string.saratov_toast_text), Toast.LENGTH_SHORT).show()
        }

        findViewById<MaterialToolbar>(R.id.toolbar).setNavigationOnClickListener {
            finish()
        }

        findViewById<MaterialToolbar>(R.id.toolbar).setOnMenuItemClickListener {
            Toast.makeText(this, getString(R.string.pencil_button_toast_text), Toast.LENGTH_SHORT).show()
            true
        }

        findViewById<Button>(R.id.logoutButton).setOnClickListener {
            Toast.makeText(this, getString(R.string.dont_leave_toast_text), Toast.LENGTH_SHORT).show()
        }
    }
}