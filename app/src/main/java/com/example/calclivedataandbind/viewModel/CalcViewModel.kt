package com.example.calclivedataandbind.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalcViewModel : ViewModel() {

    val first = MutableLiveData<String>()
    val second = MutableLiveData<String>()
    val result = INIT_VAL

    companion object {
        const val INIT_VAL = "0"
    }
}