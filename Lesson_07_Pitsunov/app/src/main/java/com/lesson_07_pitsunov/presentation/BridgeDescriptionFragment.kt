package com.lesson_07_pitsunov.presentation

import android.content.Context
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
    private var navigationController: NavigationController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_bridge_description, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigationController = (parentFragment as? NavigationController) ?: (activity as? NavigationController)
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

        val statusImageView: ImageView = view.findViewById(R.id.statusImageView)
        if (bridge.isClosed) {
            statusImageView.setImageDrawable(
                ContextCompat.getDrawable(
                    view.context, R.drawable.ic_brige_late
                )
            )
        } else if (bridge.isSoonClosed) {
            statusImageView.setImageDrawable(
                ContextCompat.getDrawable(
                    view.context, R.drawable.ic_brige_soon
                )
            )
        } else {
            statusImageView.setImageDrawable(
                ContextCompat.getDrawable(
                    view.context, R.drawable.ic_brige_normal
                )
            )
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
        if (!bridge.isClosed) {
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
                navigationController?.back()
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