package com.ndiamanti.stringcalculator;

public class StringCalculator {

    public Integer add(String str) {
        if (str.isEmpty())
            return 0;
        else return Integer.valueOf(str);
    }
}
