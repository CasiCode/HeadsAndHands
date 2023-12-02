package com.lesson_07_pitsunov.presentation

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lesson_07_pitsunov.data.model.Bridge

class BridgesAdapter: RecyclerView.Adapter<BridgeViewHolder>() {
    private val bridges = mutableListOf<Bridge>()

    lateinit var itemListener: ItemListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BridgeViewHolder {
        return BridgeViewHolder(parent, itemListener)
    }

    override fun getItemCount(): Int {
        return bridges.size
    }

    override fun onBindViewHolder(holder: BridgeViewHolder, position: Int) {
        holder.bind(bridges[position])
    }

    fun submitList(bridges: List<Bridge>) {
        this.bridges.clear()
        this.bridges.addAll(bridges)
        notifyDataSetChanged()
    }
}