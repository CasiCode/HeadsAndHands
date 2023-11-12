package com.lesson_04_pitsunov

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lesson_04_pitsunov.databinding.ItemBaseInfoBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.snackbar.Snackbar

class BaseInfoItemViewHolder(
    parent: ViewGroup
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_base_info, parent, false)
) {
    private val binding by viewBinding(ItemBaseInfoBinding::bind)

    fun bind(item: ListItem) = with(binding) {
        root.setOnClickListener { view ->
            Snackbar.make(view, item.title, Snackbar.LENGTH_LONG).show()
        }
        itemImageView.setImageResource(item.image)
        itemTitleTextView.text = item.title

        if (item.info == null) {
            itemDetailedInfoTextView.visibility = View.GONE
        } else {
            itemDetailedInfoTextView.visibility = View.VISIBLE
            itemDetailedInfoTextView.text = item.info
        }
    }
}
