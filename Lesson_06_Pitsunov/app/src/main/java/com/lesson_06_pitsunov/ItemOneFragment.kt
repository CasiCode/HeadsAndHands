package com.lesson_06_pitsunov

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar

class ItemOneFragment : Fragment(R.layout.fragment_item_one) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<MaterialToolbar>(R.id.itemOneToolbar).setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.searchMenuItem -> {
                    Toast.makeText(
                        this@ItemOneFragment.requireActivity(),
                        getString(R.string.search_menu_item_toast_text),
                        Toast.LENGTH_SHORT
                    ).show()
                    true
                }

                R.id.dropdownMenuFirstItem -> {
                    Toast.makeText(
                        this@ItemOneFragment.requireActivity(),
                        getString(R.string.menu_item_one_toast),
                        Toast.LENGTH_SHORT
                    ).show()
                    true
                }

                R.id.dropdownMenuSecondItem -> {
                    Toast.makeText(
                        this@ItemOneFragment.requireActivity(),
                        getString(R.string.menu_item_two_toast),
                        Toast.LENGTH_SHORT
                    ).show()
                    true
                }

                R.id.dropdownMenuThirdItem -> {
                    Toast.makeText(
                        this@ItemOneFragment.requireActivity(),
                        getString(R.string.menu_item_three_toast),
                        Toast.LENGTH_SHORT
                    ).show()
                    true
                }

                else -> false
            }
        }
    }
}