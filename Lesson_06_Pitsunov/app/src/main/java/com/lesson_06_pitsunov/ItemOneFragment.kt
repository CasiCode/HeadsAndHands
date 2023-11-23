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
                        "Поиск",
                        Toast.LENGTH_SHORT
                    ).show()
                    true
                }

                R.id.dropdownMenuFirstItem -> {
                    Toast.makeText(
                        this@ItemOneFragment.requireActivity(),
                        "Айтем 1",
                        Toast.LENGTH_SHORT
                    ).show()
                    true
                }

                R.id.dropdownMenuSecondItem -> {
                    Toast.makeText(
                        this@ItemOneFragment.requireActivity(),
                        "Айтем 2",
                        Toast.LENGTH_SHORT
                    ).show()
                    true
                }

                R.id.dropdownMenuThirdItem -> {
                    Toast.makeText(
                        this@ItemOneFragment.requireActivity(),
                        "Айтем 3",
                        Toast.LENGTH_SHORT
                    ).show()
                    true
                }

                else -> false
            }
        }
    }
}