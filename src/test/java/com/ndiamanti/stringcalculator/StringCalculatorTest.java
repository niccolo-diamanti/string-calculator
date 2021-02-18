package com.ndiamanti.stringcalculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StringCalculatorTest {

    @Test
    public void add_shouldReturnZeroIfEmptyString() {
        StringCalculator stringCalculator = new StringCalculator();
        Integer value = stringCalculator.add("");
        assertEquals(value, 0);
    }

    @Test
    public void add_shouldReturnGivenNumber() {
        StringCalculator stringCalculator = new StringCalculator();
        Integer value1 = stringCalculator.add("1");
        Integer value2 = stringCalculator.add("2");
        assertEquals(1, value1);
        assertEquals(2, value2);
    }
}