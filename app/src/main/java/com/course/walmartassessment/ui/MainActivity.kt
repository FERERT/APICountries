package com.course.walmartassessment.ui

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.course.walmartassessment.R
import com.course.walmartassessment.state.CountryApiState
import com.course.walmartassessment.viewmodel.MainViewModel
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.country_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.countryApiState.observe(this) {
            when (it) {
                is CountryApiState.Failure -> {
                    Toast.makeText(this, it.errorMessage, Toast.LENGTH_SHORT).show()
                }
                CountryApiState.Loading -> {
                    findViewById<ProgressBar>(R.id.progressBar).visibility = View.VISIBLE
                }
                is CountryApiState.Success -> {
                    findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
                    val adapter = CountryAdapter(it.countries)
                    recyclerView.apply {
                        this.adapter = adapter
                    }
                }
                else -> {}
            }
        }
    }
}