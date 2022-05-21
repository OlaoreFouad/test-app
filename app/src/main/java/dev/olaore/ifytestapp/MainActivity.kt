package dev.olaore.ifytestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dev.olaore.ifytestapp.databinding.ActivityMainBinding
import java.lang.Exception
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var stopsAdapter: StopListAdapter

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.submit.setOnClickListener { onSubmit() }
    }

    private fun onSubmit() {
        val submitResponse = viewModel.submit()

        if (!submitResponse) {
            Toast.makeText(
                this, "Please fucking enter at least one name!",
                Toast.LENGTH_LONG).show()
        }

    }

}
