package com.lesson_06_pitsunov

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class ItemThreeFragment : Fragment() {
    private var isButtonChecked: Boolean = false
    private var fragment: ViewPagerFragment? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_item_three, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.button)
        button.setOnClickListener {
            when (isButtonChecked) {
                true -> {
                    childFragmentManager.commit {
                        fragment?.let { remove(it) }
                    }
                    fragment = null
                    button.text = getString(R.string.open_banner_button_text)
                }
                false -> {
                    fragment = ViewPagerFragment.newInstance()
                    childFragmentManager.commit {
                        fragment?.let { add(R.id.fragmentFrameLayout, it) }
                    }
                    button.text = getString(R.string.close_banner_button_text)
                }
            }
            isButtonChecked = !isButtonChecked
        }
    }
}