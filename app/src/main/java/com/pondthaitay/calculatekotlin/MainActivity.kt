package com.pondthaitay.calculatekotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener, MainInterface.View {

    var tvResult: TextView? = null
    var etNumberOne: EditText? = null
    var etNumberTwo: EditText? = null
    var presenter: MainInterface.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindView()
        setupInstance()
    }

    private fun setupInstance() {
        presenter = MainPresenter.create(this)
    }

    private fun bindView() {
        tvResult = findViewById(R.id.tv_result) as TextView
        etNumberOne = findViewById(R.id.et_number1) as EditText
        etNumberTwo = findViewById(R.id.et_number2) as EditText
    }

    private fun setupValue(): MutableList<Int> {
        return mutableListOf(etNumberOne?.text?.toString()!!.toInt(), etNumberTwo?.text?.toString()!!.toInt())
    }

    override fun onClick(v: View?) {
        try {
            when (v?.id) {
                R.id.btn_plus -> presenter?.plus(setupValue())
                R.id.btn_minus -> presenter?.minus(setupValue())
                R.id.btn_multiply -> presenter?.multiply(setupValue())
                R.id.btn_divide -> presenter?.divide(setupValue())
            }
        } catch (exception: IllegalArgumentException) {
            setResultCalculate(exception.message)
        }
    }

    override fun setResultCalculate(result: String?) {
        tvResult?.text = result
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.destroy()
    }
}