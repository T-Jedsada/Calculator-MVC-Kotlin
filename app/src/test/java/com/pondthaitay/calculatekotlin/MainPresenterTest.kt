package com.pondthaitay.calculatekotlin

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
class MainPresenterTest {

    @Mock
    private var mockView: MainInterface.View? = null

    private var presenter: MainPresenter? = null
    private var calculator: Calculator? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = MainPresenter(mockView!!)
        calculator = Calculator.instance
        presenter?.setCalculator(calculator!!)
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        presenter?.destroy()
    }

    @Test
    @Throws(Exception::class)
    fun create() {
        Assert.assertNotNull(MainPresenter.create(mockView!!))
    }

    @Test
    @Throws(Exception::class)
    fun plus() {
        presenter?.plus(mutableListOf(5, 5))
        verify(mockView, times(1))?.setResultCalculate(10.toString())
    }

    @Test
    @Throws(Exception::class)
    fun minus() {
        presenter?.minus(mutableListOf(5, 5))
        verify(mockView, times(1))?.setResultCalculate(0.toString())
    }

    @Test
    @Throws(Exception::class)
    fun multiply() {
        presenter?.multiply(mutableListOf(5, 5))
        verify(mockView, times(1))?.setResultCalculate(25.toString())
    }

    @Test
    @Throws(Exception::class)
    fun divide() {
        presenter?.divide(mutableListOf(5, 5))
        verify(mockView, times(1))?.setResultCalculate(1.toString())
    }

    @Test
    @Throws(Exception::class)
    fun divideByZero() {
        presenter?.divide(mutableListOf(5, 0))
        verify(mockView, times(1))?.setResultCalculate(DivideByZeroException().message)
    }
}