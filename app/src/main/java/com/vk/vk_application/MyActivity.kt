package com.vk.vk_application

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MyActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var button: Button

    private val adapter = MyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        button = findViewById(R.id.button)

        recyclerView.adapter = adapter

        val items = savedInstanceState?.getIntegerArrayList("items") ?: listOf(1, 2, 3, 4, 5)
        adapter.setItems(items)

        button.setOnClickListener {
            adapter.addItems(adapter.itemCount + 1)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putIntegerArrayList("items", ArrayList(adapter.getItems()))
        super.onSaveInstanceState(outState)
    }
}