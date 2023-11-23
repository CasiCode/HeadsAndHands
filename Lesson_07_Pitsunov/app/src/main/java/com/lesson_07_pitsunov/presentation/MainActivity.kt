package com.lesson_07_pitsunov.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.lesson_07_pitsunov.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.commit {
            setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            add(R.id.mainFrameLayout, BridgeListFragment.newInstance())
        }
    }
}