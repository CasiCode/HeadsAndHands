package com.lesson_05_pitsunov

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.lesson_05_pitsunov.databinding.ActivityFourthBinding
import java.text.SimpleDateFormat
import java.util.Date

class FourthActivity : AppCompatActivity() {
    private val binding by lazy { ActivityFourthBinding.inflate(LayoutInflater.from(this)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val time: Long = intent.getLongExtra(KEY_TIME, 0)
        val format = SimpleDateFormat.getDateTimeInstance()
        binding.textView.text = format.format(Date(time))

        binding.button.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            intent.putExtra(KEY_TIME, System.currentTimeMillis())
            startActivity(intent)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        val time: Long = intent!!.getLongExtra(KEY_TIME, 0)
        val format = SimpleDateFormat.getDateTimeInstance()
        binding.textView.text = format.format(Date(time))
    }

    companion object {
        private const val KEY_TIME = "KEY_TIME"

        fun createStartIntent(context: Context, value: Long): Intent {
            return Intent(context, FourthActivity::class.java).apply {
                putExtra(KEY_TIME, value)
            }
        }
    }
}