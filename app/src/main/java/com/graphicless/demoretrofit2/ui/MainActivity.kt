package com.graphicless.demoretrofit2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.graphicless.demoretrofit2.viewmodel.OverviewViewModel
import com.graphicless.demoretrofit2.R
import com.graphicless.demoretrofit2.adapter.MarsPhotoAdapter
import com.graphicless.demoretrofit2.model.MarsPhoto

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: OverviewViewModel
    private lateinit var photos: List<MarsPhoto>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[OverviewViewModel::class.java]

        val textView: TextView = findViewById(R.id.tv_total_image)

        viewModel.status.observe(this){
            textView.text = it
        }

        val recyclerView: RecyclerView = findViewById(R.id.rv_mars_photos)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        viewModel.photos.observe(this){
            photos = it
            recyclerView.adapter = MarsPhotoAdapter(photos)
        }

    }
}