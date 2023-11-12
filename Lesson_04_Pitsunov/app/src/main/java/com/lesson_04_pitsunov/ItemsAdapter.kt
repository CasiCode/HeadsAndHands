package com.lesson_04_pitsunov

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

internal const val TYPE_DETAILED_INFO_ITEM = 0
internal const val TYPE_BASE_INFO_ITEM = 1

class ItemsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items = mutableListOf<ListItem>()

    lateinit var onItemClick: (ListItem) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_BASE_INFO_ITEM -> BaseInfoItemViewHolder(parent)
            TYPE_DETAILED_INFO_ITEM -> DetailedInfoItemViewHolder(parent)
            else -> error("ViewType not supported")
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is DetailedInfoItemViewHolder -> holder.bind(items[position])
            is BaseInfoItemViewHolder -> holder.bind(items[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].isDetailed) {
            TYPE_DETAILED_INFO_ITEM
        } else {
            TYPE_BASE_INFO_ITEM
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(items: List<ListItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}