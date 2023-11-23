package com.lesson_04_pitsunov

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lesson_04_pitsunov.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(LayoutInflater.from(this)) }
    private val itemsAdapter = ItemsAdapter()
    private lateinit var layoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
        binding.toolbar.menu.findItem(R.id.homeMenuItem).setOnMenuItemClickListener {
            Toast.makeText(this@MainActivity, getString(R.string.home_menu_item_toast_text), Toast.LENGTH_SHORT).show()
            true
        }
        binding.toolbar.menu.findItem(R.id.infoMenuItem).setOnMenuItemClickListener {
            val builder = AlertDialog.Builder(this).apply {
                setTitle("ЗАЧЕМ")
                setMessage("Ты сюда тыкнул?")
                setNeutralButton("Извините") { dialog, which ->
                    Toast.makeText(applicationContext,
                        "Извиняем", Toast.LENGTH_SHORT).show()
                }
                show()
            }

            true
        }

        binding.recyclerView.adapter = itemsAdapter
        itemsAdapter.setList(ItemsList.items)

        layoutManager = GridLayoutManager(this@MainActivity, SPAN_COUNT)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (itemsAdapter.getItemViewType(position)) {
                    TYPE_DETAILED_INFO_ITEM -> 1
                    TYPE_BASE_INFO_ITEM -> 2
                    else -> -1
                }
            }
        }

        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(this@MainActivity, RecyclerView.VERTICAL).apply {
                setDrawable(
                    this@MainActivity.resources.getDrawable(
                        R.drawable.divider_drawable, this@MainActivity.theme
                    )
                )
            }
        )
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(this@MainActivity, RecyclerView.HORIZONTAL).apply {
                setDrawable(
                    this@MainActivity.resources.getDrawable(
                        R.drawable.divider_drawable, this@MainActivity.theme
                    )
                )
            }
        )
    }

    companion object {
        private const val SPAN_COUNT = 2
    }
}