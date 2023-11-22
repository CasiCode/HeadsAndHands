package com.lesson_06_pitsunov

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar

class ItemTwoFragment : Fragment(R.layout.fragment_item_two) {
    private val itemsAdapter = ItemsAdapter()
    private lateinit var layoutManager: LinearLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<MaterialToolbar>(R.id.itemTwoToolbar).setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.lampMenuItem -> {
                    Toast.makeText(
                        this@ItemTwoFragment.requireActivity(),
                        "Фонарик",
                        Toast.LENGTH_SHORT
                    ).show()
                    true
                }

                else -> false
            }
        }

        itemsAdapter.setList(ItemsList.items)
        view.findViewById<RecyclerView>(R.id.recyclerView).adapter = itemsAdapter
    }
}