package com.luxoft.cources;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    public static void init() {
        calculator = new Calculator();
    }

    @Test
    public void testSum() {
        int result = calculator.sum(2, 2);
        if (result != 4) {
            // if 2 + 2 != 4
             Assertions.fail("result != 4");
             }
        }

    @Test public void testMinus() {
        Assertions.assertEquals(0, calculator.minus(2, 2), "Minus is not correct");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/DivideData.csv", numLinesToSkip = 1)
    void testPositiveDivide(int firstParam, int secondParam, int expectedResult) {
        Calculator calculator = new Calculator();
        assertEquals(expectedResult,
                calculator.divide(firstParam, secondParam),
                String.format("Devision of '%d' on '%d' is not equals to '%d'",
                        firstParam,
                        secondParam,
                        expectedResult));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/negativeDivideData.csv", numLinesToSkip = 1)
    void testNegativeDivide(int firstParam, int secondParam, int expectedResult) {
        Calculator calculator = new Calculator();
        assertEquals(expectedResult,
                calculator.divide(firstParam, secondParam),
                String.format("Devision of '%d' on '%d' is not equals to '%d'",
                        firstParam,
                        secondParam,
                        expectedResult));
    }


    @Test
    public void testDivideWillThrowExceptionWhenDivideOnZero() {
        assertThrows(ArithmeticException.class, () ->
                calculator.divide(1, 0),
                "Division to 0 is has no ArithmeticException"

        );
    }

    @Test
    public void testMultiply() {
        Assertions.assertEquals(10, calculator.multiply(5, 2), "Multiply is not correct");
    }

}