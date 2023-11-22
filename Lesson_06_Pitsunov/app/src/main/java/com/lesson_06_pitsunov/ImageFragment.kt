package com.lesson_06_pitsunov

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import java.io.IOException
import java.net.URL

class ImageFragment : Fragment() {
    private lateinit var url: URL
    private lateinit var image: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            url = URL( it?.getString(KEY_URL) )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Thread {
            run() {
                try {
                    image = BitmapFactory.decodeStream(url.openConnection().getInputStream())
                    Handler(Looper.getMainLooper()).post {
                        run() {
                            view.findViewById<ImageView>(R.id.imageView).setImageBitmap(image)
                        }
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }.start()
    }

    companion object {
        private const val KEY_URL = "KEY_URL"

        @JvmStatic
        fun newInstance(url: String) = ImageFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_URL, url)
            }
        }
    }
}