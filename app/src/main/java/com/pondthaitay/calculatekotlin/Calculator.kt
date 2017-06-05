package com.pondthaitay.calculatekotlin

class Calculator {
    private object Instance {
        val INSTANCE = Calculator()
    }

    companion object {
        val instance: Calculator by lazy { Instance.INSTANCE }
    }

    fun plus(x: Int, y: Int): Int? = x + y

    fun minus(x: Int, y: Int): Int? = x - y

    fun multiply(x: Int, y: Int): Int? = x * y

    fun divide(x: Int, y: Int): Int? = if (y == 0) throw DivideByZeroException() else x / y
}