package com.lesson_06_pitsunov

import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.marginStart
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder(
    parent: ViewGroup
) : RecyclerView.ViewHolder(
    LayoutInflater
        .from(parent.context)
        .inflate(
            R.layout.item_payment,
            parent,
            false
        )
) {
    fun bind(item: ListItem) {
        itemView.findViewById<ImageView>(R.id.imageView)
            .setImageResource(item.image)
        itemView.findViewById<TextView>(R.id.titleTextView).text = item.title
        itemView.findViewById<TextView>(R.id.barcodeTextView).text = item.barcode.toString()

        val infoImageClickableView: ImageView = itemView.findViewById(R.id.infoImageClickableView)
        val moreImageClickableView: ImageView = itemView.findViewById(R.id.moreImageClickableView)
        val sendImageClickableView: ImageView = itemView.findViewById(R.id.sendImageClickableView)
        infoImageClickableView.setOnClickListener {
            Toast.makeText(
                itemView.context,
                infoImageClickableView.contentDescription.toString(),
                Toast.LENGTH_SHORT
            ).show()
        }
        moreImageClickableView.setOnClickListener {
            Toast.makeText(
                itemView.context,
                moreImageClickableView.contentDescription.toString(),
                Toast.LENGTH_SHORT
            ).show()
        }
        sendImageClickableView.setOnClickListener {
            Toast.makeText(
                itemView.context,
                sendImageClickableView.contentDescription.toString(),
                Toast.LENGTH_SHORT
            ).show()
        }

        val infoTextView: TextView = itemView.findViewById(R.id.infoTextView)
        infoTextView.text = item.info
        if (item.isWarning) {
            infoTextView.setTextColor(
                ContextCompat.getColor(itemView.context, R.color.warning)
            )
            itemView.findViewById<ImageView>(R.id.warningImageView).visibility = VISIBLE
        } else {
            infoTextView.setTextColor(
                ContextCompat.getColor(itemView.context, R.color.black)
            )
            itemView.findViewById<ImageView>(R.id.warningImageView).visibility = GONE
        }

        val dayValueTextView: TextView = itemView.findViewById(R.id.dayValueTextView)
        val nightValueTextView: TextView = itemView.findViewById(R.id.nightValueTextView)
        val peakValueTextView: TextView = itemView.findViewById(R.id.peakValueTextView)
        val dayValueEditView: EditText = itemView.findViewById(R.id.dayValueEditText)
        val nightValueEditView: EditText = itemView.findViewById(R.id.nightValueEditText)
        val peakValueEditView: EditText = itemView.findViewById(R.id.peakValueEditText)
        if (item.isPrecise) {
            peakValueEditView.visibility = VISIBLE
            peakValueTextView.visibility = VISIBLE
            nightValueEditView.visibility = VISIBLE
            nightValueTextView.visibility = VISIBLE

            dayValueTextView.text = itemView.context.getString(R.string.day_value_textview_text)

            peakValueEditView.hint = item.previousValuePeak.toString()
            nightValueEditView.hint = item.previousValueNight.toString()
        } else {
            peakValueEditView.visibility = GONE
            peakValueTextView.visibility = GONE
            nightValueEditView.visibility = GONE
            nightValueTextView.visibility = GONE

            dayValueTextView.text = itemView.context.getString(R.string.new_value_textview_text)
        }
        dayValueEditView.hint = item.previousValueDay.toString()
    }
}
