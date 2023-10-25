package com.example.lifecycleawareness

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel : ViewModel() {

    // Create a LiveData to observe the lifecycle events
    private val _lifecycleEvents = MutableLiveData<String>()
    val lifecycleEvents: LiveData<String> = _lifecycleEvents

    // Add a function to append events with timestamps
    fun appendLifecycleEvent(event: String) {
        val currentTime = SimpleDateFormat("HH:mm:ss:SSS", Locale.US).format(Date())
        _lifecycleEvents.value = "${_lifecycleEvents.value ?: ""}${event} was fired on $currentTime\n"
    }
}



