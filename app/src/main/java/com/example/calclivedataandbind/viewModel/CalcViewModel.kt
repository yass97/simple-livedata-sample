package com.example.calclivedataandbind.viewModel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class CalcViewModel : ViewModel() {

    var first = MutableLiveData<String>()
    var second = MutableLiveData<String>()
    var result = INIT_VAL

    init {
        first.value = INIT_VAL
        second.value = INIT_VAL
    }

    companion object {
        const val INIT_VAL = "0"
    }
}