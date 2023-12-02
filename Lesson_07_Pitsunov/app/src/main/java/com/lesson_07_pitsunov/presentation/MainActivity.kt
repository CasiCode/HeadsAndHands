package com.lesson_07_pitsunov.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.lesson_07_pitsunov.R

class MainActivity : AppCompatActivity(), NavigationController {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.commit {
            add(R.id.mainFrameLayout, BridgeListFragment.newInstance())
        }
    }

    override fun navigate(fragment: Fragment) {
        supportFragmentManager.commit {
            setCustomAnimations(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right,
                R.anim.slide_in_right, R.anim.slide_out_left
            )
            add(R.id.mainFrameLayout, fragment)
            addToBackStack(fragment.tag)
        }
    }

    override fun back() {
        supportFragmentManager.popBackStack()
    }
}