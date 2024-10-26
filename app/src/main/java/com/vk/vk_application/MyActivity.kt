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

        button.setOnClickListener {
            adapter.addItems(adapter.itemCount + 1)
        }


        if (savedInstanceState != null) {
            val itemCount = savedInstanceState.getInt("itemCount", adapter.itemCount)
            val items = ArrayList<Int>()

            for (i in 1..itemCount) {
                items.add(i)
            }
            adapter.setItems(items)

        } else {
            adapter.setItems(listOf(1, 2, 3, 4, 5))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("itemCount", adapter.itemCount)
        super.onSaveInstanceState(outState)
    }
}