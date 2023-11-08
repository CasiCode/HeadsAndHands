package com.lesson_05_pitsunov

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.lesson_05_pitsunov.databinding.ActivityFifthBinding

class FifthActivity : AppCompatActivity() {
    private val binding by lazy { ActivityFifthBinding.inflate(LayoutInflater.from(this)) }
    private val data = Data()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.deliverResultButton.setOnClickListener {
            setResult(Activity.RESULT_OK, Intent().apply {
                putExtra(ThirdActivity.KEY_QUERY, binding.editText.text?.toString().orEmpty())
            })
            finish()
        }

        binding.saveButton.setOnClickListener {
            val input = binding.editText.text.toString()
            data.value = input
            binding.textView.text = data.value
        }
    }

    override fun onStart() {
        super.onStart()
        binding.textView.text = data.value
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_DATA, data)
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val savedData: String?
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            @Suppress("DEPRECATION")
            savedData = savedInstanceState.getParcelable<Data>(KEY_DATA)?.value
        }
        else {
            savedData = savedInstanceState.getParcelable(
                KEY_DATA, Data::class.java
            )?.value
        }
        data.value = savedData.orEmpty()
        binding.textView.text = savedData
    }

    companion object {
        private const val KEY_DATA = "KEY_DATA"
    }
}