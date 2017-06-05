package com.pondthaitay.calculatekotlin

class MainInterface {

    interface View {
        fun setResultCalculate(result: String?)
    }

    interface Presenter {
        fun plus(numbers: MutableList<Int>)
        fun minus(numbers: MutableList<Int>)
        fun multiply(numbers: MutableList<Int>)
        fun divide(numbers: MutableList<Int>)
        fun destroy()
    }
}