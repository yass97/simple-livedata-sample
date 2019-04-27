package com.example.calclivedataandbind.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.calclivedataandbind.R
import com.example.calclivedataandbind.databinding.ActivityMainBinding
import com.example.calclivedataandbind.viewModel.CalcViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val calcViewModel: CalcViewModel by lazy {
        ViewModelProviders.of(this).get(CalcViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // バインドする
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        // layoutのdataタグに記述したcalcViewModelにCalcViewModelのインスタンスを設定する
        binding.calcViewModel = calcViewModel
    }

    override fun onResume() {
        super.onResume()

        // 数値入力欄を監視し、数値が変更されたらその都度合計項目に計算結果を設定する
        val observer = Observer<String> {

            // 入力項目が空文字または空白でない場合は計算を行う
            if (first_value.text.isNotBlank() && second_value.text.isNotBlank()) {
                // 計算結果を設定する
                val calcResult = calcViewModel.first.value!!.toLong() + calcViewModel.second.value!!.toLong()
                calc_result.text = calcResult.toString()
            }
        }

        // 入力項目を監視する
        calcViewModel.first.observe(this, observer)
        calcViewModel.second.observe(this, observer)
    }
}
