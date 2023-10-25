package com.example.lifecycleawareness

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.lifecycleawareness.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.lifecycleEvents.observe(this) { events ->
            val allEvents = StringBuilder()
            for (event in events) {
                allEvents.append(event).append(" ")
            }
            binding.textView.text = allEvents
        }

        viewModel.appendLifecycleEvent("onCreate")
    }

    override fun onStart() {
        super.onStart()
        viewModel.appendLifecycleEvent("onStart")
    }

    override fun onResume() {
        super.onResume()
        viewModel.appendLifecycleEvent("onResume")
        viewModel.appendLifecycleEvent("*****") // Append ***** after onResume
    }

    override fun onPause() {
        super.onPause()
        viewModel.appendLifecycleEvent("onPause")
        viewModel.appendLifecycleEvent("*****") // Append ***** after onPause
    }

    override fun onStop() {
        super.onStop()
        viewModel.appendLifecycleEvent("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.appendLifecycleEvent("onDestroy")
        viewModel.appendLifecycleEvent("*****") // Append ***** after onDestroy
    }
}







