package com.ndiamanti.stringcalculator;

public interface StringCalculator {

    String DEFAULT_DELIMITER = ",";
    Integer MAX_NUMBER_ALLOWED = 1000;

    Integer add(String numbers);
}
