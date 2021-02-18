package com.ndiamanti.stringcalculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void add_shouldReturnZeroIfEmptyString() {
        Integer value = stringCalculator.add("");
        assertEquals(value, 0);
    }

    @Test
    public void add_shouldReturnGivenNumber() {
        Integer value1 = stringCalculator.add("1");
        Integer value2 = stringCalculator.add("2");
        assertEquals(1, value1);
        assertEquals(2, value2);
    }

    @Test
    public void add_shouldAddInput() {
        Integer value = stringCalculator.add("10,2");
        assertEquals(12, value);
    }

    @Test
    public void add_shouldAddInputWithNewline() {
        Integer value = stringCalculator.add("10\n2");
        assertEquals(12, value);
    }

    @Test
    public void add_shouldAddInputWithNewlineAndComma() {
        Integer value = stringCalculator.add("1\n2,3\n4");
        assertEquals(10, value);
    }
}