package com.ndiamanti.stringcalculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StringCalculatorTest {

    @Test
    public void add_shouldReturnZeroIfEmptyString() {
        StringCalculator stringCalculator = new StringCalculator();
        Integer value = stringCalculator.add("");
        assertEquals(value, 0);
    }
}