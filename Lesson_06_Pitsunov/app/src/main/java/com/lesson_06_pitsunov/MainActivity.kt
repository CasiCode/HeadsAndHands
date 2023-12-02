package com.lesson_06_pitsunov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemOneFragment = ItemOneFragment()
        val itemTwoFragment = ItemTwoFragment()
        val itemThreeFragment = ItemThreeFragment()

        setCurrentFragment(itemOneFragment)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.itemOneMenuItem -> setCurrentFragment(itemOneFragment)
                R.id.itemTwoMenuItem -> setCurrentFragment(itemTwoFragment)
                R.id.itemTreeMenuItem -> setCurrentFragment(itemThreeFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.commit {
            setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            replace(R.id.container, fragment)
        }
}