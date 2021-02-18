package com.ndiamanti.stringcalculator;

import java.util.Arrays;

public class StringCalculator {

    public Integer add(String str) {
        if (str.isEmpty())
            return 0;
        else
            return Arrays.stream(str.replaceAll("\n", ",").split(",")).map(Integer::valueOf).reduce(0, Integer::sum);
    }
}
