package com.pondthaitay.calculatekotlin

import java.lang.ref.WeakReference


class MainPresenter(view: MainInterface.View) : MainInterface.Presenter {

    private var mView: WeakReference<MainInterface.View>? = null
    private var mCalculator: Calculator? = null

    init {
        mView = WeakReference(view)
        mCalculator = Calculator.instance
    }

    companion object {
        fun create(view: MainInterface.View): MainInterface.Presenter {
            return MainPresenter(view)
        }
    }

    fun setCalculator(mockCalculator: Calculator) {
        this.mCalculator = mockCalculator
    }

    override fun plus(numbers: MutableList<Int>) {
        mView?.get()?.setResultCalculate(mCalculator?.plus(numbers[0], numbers[1]).toString())
    }

    override fun minus(numbers: MutableList<Int>) {
        mView?.get()?.setResultCalculate(mCalculator?.minus(numbers[0], numbers[1]).toString())
    }

    override fun multiply(numbers: MutableList<Int>) {
        mView?.get()?.setResultCalculate(mCalculator?.multiply(numbers[0], numbers[1]).toString())
    }

    override fun divide(numbers: MutableList<Int>) {
        try {
            mView?.get()?.setResultCalculate(mCalculator?.divide(numbers[0], numbers[1]).toString())
        } catch (exception: DivideByZeroException) {
            mView?.get()?.setResultCalculate(exception.message)
        }
    }

    override fun destroy() {
        mView?.clear()
    }
}