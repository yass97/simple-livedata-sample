package com.example.calclivedataandbind

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {

    val first = MutableLiveData<String>()
    val second = MutableLiveData<String>()
    val result = INIT_VAL

    companion object {
        const val INIT_VAL = "0"
    }
}