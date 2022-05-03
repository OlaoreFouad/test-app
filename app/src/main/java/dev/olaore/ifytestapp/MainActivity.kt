package dev.olaore.ifytestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.olaore.ifytestapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val stops: MutableList<Stop> = mutableListOf()

    private lateinit var stopsAdapter: StopListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.setupUi()
    }

    private fun ActivityMainBinding.setupUi() {
        stopsAdapter = StopListAdapter {  position ->
            onItemRemoved(position)
        }
        stopsList.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = stopsAdapter
        }
        addStop.setOnClickListener { addStop() }
    }

    private fun addStop() {
        val stopSize = stops.size
        stops.add(Stop("Stop ${stopSize + 1}"))
        stopsAdapter.submitList(stops.toList())
    }

    private fun removeStop(index: Int) {
        stops.removeAt(index)
        stopsAdapter.submitList(stops.toList())
    }

    private fun onItemRemoved(index: Int) {
        Toast.makeText(this, "Item at index: $index removed!", Toast.LENGTH_LONG).show()
        this.removeStop(index)
    }
}