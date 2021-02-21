package com.ndiamanti.stringcalculator;

public interface StringCalculator {

    Integer MAX_NUMBER_ALLOWED = 1000;
    String DELIMITER_REGEX = "^//(.*)\\n";
    String DYNAMIC_DELIMITER_PREFIX = "//";
    String DEFAULT_DELIMITER = ",";

    Integer add(String numbers);
}
