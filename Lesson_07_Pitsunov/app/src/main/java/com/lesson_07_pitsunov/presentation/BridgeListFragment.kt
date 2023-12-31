package com.lesson_07_pitsunov.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.lesson_07_pitsunov.R
import com.lesson_07_pitsunov.data.ApiClient
import com.lesson_07_pitsunov.data.model.Bridge
import kotlinx.coroutines.launch

class BridgeListFragment : Fragment() {
    private val adapter = BridgesAdapter()
    private var navigationController: NavigationController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_bridge_list, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigationController = (parentFragment as? NavigationController) ?: (activity as? NavigationController)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ProgressBar>(R.id.progressBar).isVisible = false
        view.findViewById<RecyclerView>(R.id.recyclerView).adapter = adapter.apply {
            itemListener = ItemListener { item ->
                navigationController?.navigate(BridgeDescriptionFragment.newInstance(item))
            }
        }
        loadBridges()

        view.findViewById<MaterialToolbar>(R.id.toolbar)
            .setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.mapMenuItem -> {
                        Toast.makeText(view.context, "Карта", Toast.LENGTH_SHORT)
                            .show()
                        true
                    }
                    R.id.infoMenuItem -> {
                        Toast.makeText(view.context, "Информация", Toast.LENGTH_SHORT)
                            .show()
                        true
                    }
                    else -> false
                }
            }
    }

    private fun loadBridges() {
        lifecycleScope.launch {
            view?.findViewById<ProgressBar>(R.id.progressBar)?.isVisible = true
            val bridges = ApiClient.apiService.getBridges().map { Bridge(it) }
            adapter.submitList(bridges)
            view?.findViewById<ProgressBar>(R.id.progressBar)?.isVisible = false
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BridgeListFragment()
    }
}