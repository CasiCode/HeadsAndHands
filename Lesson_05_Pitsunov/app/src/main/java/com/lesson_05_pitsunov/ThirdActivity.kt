package com.lesson_05_pitsunov

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.lesson_05_pitsunov.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private val binding by lazy { ActivityThirdBinding.inflate(LayoutInflater.from(this)) }

    private val launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            Snackbar.make(
                binding.root,
                data!!.getStringExtra(KEY_QUERY).toString(),
                Snackbar.LENGTH_LONG
            ).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.goToOneButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.goToFiveButton.setOnClickListener {
            val intent = Intent(this, FifthActivity::class.java)
            launcher.launch(intent)
        }
    }

    companion object {
        const val KEY_QUERY = "KEY_QUERY"
    }
}