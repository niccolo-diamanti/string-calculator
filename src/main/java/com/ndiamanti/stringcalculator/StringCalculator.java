package com.ndiamanti.stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringCalculator {

    public Integer add(String numbers) {
        if (numbers.isEmpty())
            return 0;
        else {
            Map<Boolean, List<Integer>> partition = Arrays.stream(numbers.replaceAll("\n", ",").split(","))
                    .map(Integer::valueOf)
                    .collect(Collectors.partitioningBy(i -> i < 0));
            if (!partition.get(true).isEmpty())
                throw new NegativeNumbersException(partition.get(true).stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(",")));
            else
                return partition.get(false).stream().reduce(0, Integer::sum);
        }
    }

    public static class NegativeNumbersException extends RuntimeException {
        public NegativeNumbersException(String numbers) {
            super("Negatives not allowed: " + numbers);
        }
    }
}
