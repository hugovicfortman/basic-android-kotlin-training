package com.example.gallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery.adapter.ImageGridItemAdapter
import com.example.gallery.data.DataSource
import com.example.gallery.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val dataset = DataSource().loadImageFiles()
        val recyclerView: RecyclerView = binding.galleryRecyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = ImageGridItemAdapter(this, dataset)
        // recyclerView.setHasFixedSize(true)
    }
}