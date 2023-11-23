package com.lesson_04_pitsunov

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.snackbar.Snackbar
import com.lesson_04_pitsunov.databinding.ItemDetailedInfoBinding

class DetailedInfoItemViewHolder(
    parent: ViewGroup
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_detailed_info, parent, false)
) {
    private val binding by viewBinding(ItemDetailedInfoBinding::bind)
    @SuppressLint("ResourceAsColor")
<<<<<<< HEAD
    fun bind(item: ListItem) = with(binding) {
=======
    fun bind(item: DetailedInfoItem) = with(binding) {
>>>>>>> 855f3571098986938cf7f2ea51174b925e10a1f3
        root.setOnClickListener {view ->
            Snackbar.make(view, item.title, Snackbar.LENGTH_LONG).show()
        }
        itemImageView.setImageResource(item.image)
        itemTitleTextView.text = item.title
<<<<<<< HEAD
        if (item.info?.isEmpty() == true) {
=======
        if (item.info.isEmpty()) {
>>>>>>> 855f3571098986938cf7f2ea51174b925e10a1f3
            itemDetailedInfoTextView.visibility = GONE
        } else {
            itemDetailedInfoTextView.text = item.info
            if (item.isWarning) {
                itemDetailedInfoTextView.setTextColor(R.attr.customTextColorWarning)
            }
<<<<<<< HEAD
            else {
                itemDetailedInfoTextView.setTextColor(R.attr.customTextColorSecondary)
            }
=======
>>>>>>> 855f3571098986938cf7f2ea51174b925e10a1f3
        }
    }
}
