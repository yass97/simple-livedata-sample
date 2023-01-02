package com.example.simple_live_data_sample

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {
    val first = MutableLiveData("")
    val second = MutableLiveData("")
    val result = MediatorLiveData<String>().apply {
        addSource(first) { value = calc() }
        addSource(second) { value = calc() }
    }

    private fun calc(): String {
        val firstValue = if (first.value.isNullOrBlank()) 0 else first.value!!.toInt()
        val secondValue = if (second.value.isNullOrBlank()) 0 else second.value!!.toInt()
        return (firstValue + secondValue).toString()
    }
}
