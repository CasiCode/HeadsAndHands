package com.lesson_07_pitsunov.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.lesson_07_pitsunov.R
import com.lesson_07_pitsunov.data.model.Bridge
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

const val SECONDS_IN_HOUR: Long = 60 * 60

class BridgeViewHolder(
    parent: ViewGroup,
    private val itemListener: ItemListener
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context)
        .inflate(R.layout.item_bridge_info, null, false)
) {
    fun bind(item: Bridge) {
        val format = SimpleDateFormat("HH:mm")
        // Запрашиваю текущее время по Питеру
        format.timeZone = TimeZone.getTimeZone("Europe/Saint-Petersburg")
        val currentTime = format.parse(
            format.format( Date() )
        )
        for (divorce in item.divorces) { // Использую break, так что forEach не подойдет
            val startTime: Date? = format.parse(divorce.start)
            val warnTime: Date? = format.parse(
                format.format(
                    Date.from(
                        startTime?.toInstant()?.minusSeconds(SECONDS_IN_HOUR)
                    )
                )
            )
            val endTime: Date? = format.parse(divorce.end)

            val statusImageView: ImageView = itemView.findViewById(R.id.statusImageView)
            if (currentTime.after(startTime) && currentTime.before(endTime)) {
                statusImageView.setImageDrawable(
                        ContextCompat.getDrawable(
                            itemView.context, R.drawable.ic_brige_late
                        )
                    )
                item.isClosed = true
                break
            } else if (currentTime.after(warnTime) && currentTime.before(startTime)) {
                statusImageView.setImageDrawable(
                        ContextCompat.getDrawable(
                            itemView.context, R.drawable.ic_brige_soon
                        )
                    )
                item.isSoonClosed = true
                break
            } else {
                statusImageView.setImageDrawable(
                        ContextCompat.getDrawable(
                            itemView.context, R.drawable.ic_brige_normal
                        )
                    )
            }
        }

        when (Locale.getDefault().country) {
            "RU" -> itemView.findViewById<TextView>(R.id.nameTextView).text = item.name
            else -> itemView.findViewById<TextView>(R.id.nameTextView).text = item.nameEng
        }

        itemView.findViewById<TextView>(R.id.divorceTimeTextView).text = buildString {
            item.divorces.forEach {
                this
                    .append(it.start)
                    .append("-")
                    .append(it.end)
                    .append(" ")
            }
        }

        itemView.setOnClickListener {
            itemListener.onItemClick(item)
        }
    }
}