package com.lesson_07_pitsunov.presentation

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.bumptech.glide.Glide
import com.google.android.material.appbar.MaterialToolbar
import com.lesson_07_pitsunov.R
import com.lesson_07_pitsunov.data.model.Bridge
import com.lesson_07_pitsunov.data.model.BridgeDivorce
import com.lesson_07_pitsunov.values.StringConstants.NULL_STRING
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class BridgeDescriptionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_bridge_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val _bridge: Bridge?
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            @Suppress("DEPRECATION")
            _bridge = arguments?.getParcelable<Bridge>(KEY_BRIDGE)
        } else {
            _bridge = arguments?.getParcelable(
                KEY_BRIDGE,
                Bridge::class.java
            )
        }
        val bridge: Bridge = _bridge?: Bridge(
            name = NULL_STRING,
            nameEng = NULL_STRING,
            description = NULL_STRING,
            descriptionEng = NULL_STRING,
            divorces = mutableListOf(
                BridgeDivorce(
                    start = "00:00",
                    end = "00:00"
                )
            ),
            photoOpenURL = ERROR_IMAGE_URL,
            photoCloseURL = ERROR_IMAGE_URL
        )

        var isOpen: Boolean = false
        val format = SimpleDateFormat("HH:mm")
        val currentTime = format.parse(
            format.format( Date() )
        )
        for (divorce in bridge.divorces) { // Использую break, так что forEach не подойдет
            val startTime: Date? = format.parse(divorce.start)
            val warnTime: Date? = format.parse(
                format.format(
                    Date.from(
                        startTime?.toInstant()?.minusSeconds(SECONDS_IN_HOUR)
                    )
                )
            )
            val endTime: Date? = format.parse(divorce.end)

            val statusImageView: ImageView = view.findViewById(R.id.statusImageView)
            if (currentTime.after(startTime) && currentTime.before(endTime)) {
                statusImageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        view.context, R.drawable.ic_brige_late
                    )
                )
                isOpen = false
                break
            } else if (currentTime.after(warnTime) && currentTime.before(startTime)) {
                statusImageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        view.context, R.drawable.ic_brige_soon
                    )
                )
                isOpen = true
            } else {
                statusImageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        view.context, R.drawable.ic_brige_normal
                    )
                )
                isOpen = true
            }
        }

        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        val descriptionTextView: TextView = view.findViewById(R.id.descriptionTextView)
        when (Locale.getDefault().country) {
            "RU" -> {
                nameTextView.text = bridge.name
                descriptionTextView.text = bridge.description
            }
            else -> {
                nameTextView.text = bridge.nameEng
                descriptionTextView.text = bridge.descriptionEng
            }
        }

        view.findViewById<TextView>(R.id.divorceTimeTextView).text = buildString {
            bridge.divorces.forEach {
                this
                    .append(it.start)
                    .append("-")
                    .append(it.end)
                    .append(" ")
            }
        }

        val toolbarImageView: ImageView = view.findViewById(R.id.toolbarImageView)
        if (isOpen) {
            Glide.with(view.context)
                .load(bridge.photoOpenURL)
                .into(toolbarImageView)
        } else {
            Glide.with(view.context)
                .load(bridge.photoCloseURL)
                .into(toolbarImageView)
        }

        view.findViewById<MaterialToolbar>(R.id.bridgeDescriptionToolbar)
            .setNavigationOnClickListener {
                parentFragmentManager.commit {
                    setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                    hide(this@BridgeDescriptionFragment)
                    remove(this@BridgeDescriptionFragment)
                }
            }
    }

    companion object {
        private const val ERROR_IMAGE_URL =
            "https://ru.hostings.info/upload/images/2021/12/e11044b915dc39afc3004430606bd6d1.jpg"

        private const val KEY_BRIDGE = "KEY_BRIDGE"

        @JvmStatic
        fun newInstance(bridge: Bridge) = BridgeDescriptionFragment().apply {
            arguments = Bundle().apply {
                putParcelable(KEY_BRIDGE, bridge)
            }
        }
    }
}