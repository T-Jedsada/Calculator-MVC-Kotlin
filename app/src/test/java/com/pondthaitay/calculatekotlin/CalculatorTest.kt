package com.pondthaitay.calculatekotlin

import org.junit.Assert
import org.junit.Test

class CalculatorTest {
    var cal: Calculator = Calculator.instance

    @Test
    @Throws(Exception::class)
    fun plus() {
        val result = cal.plus(5, 5)
        Assert.assertEquals(10, result)
    }

    @Test
    @Throws(Exception::class)
    fun minus() {
        val result = cal.minus(5, 5)
        Assert.assertEquals(0, result)
    }

    @Test
    @Throws(Exception::class)
    fun multiply() {
        val result = cal.multiply(5, 5)
        Assert.assertEquals(25, result)
    }

    @Test
    @Throws(Exception::class)
    fun divide() {
        val result = cal.divide(5, 5)
        Assert.assertEquals(1, result)
    }
}