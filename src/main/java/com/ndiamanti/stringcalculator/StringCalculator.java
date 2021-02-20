package com.ndiamanti.stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringCalculator {

    private final String defaultDelimiter = ",";

    public Integer add(String numbers) {
        if (numbers.isEmpty())
            return 0;
        else {
            Map<Boolean, List<Integer>> partition = splitNegativeAndPositiveNumbers(numbers);
            if (!partition.get(true).isEmpty())
                throw new NegativeNumbersException(joinNumbersByDelimiter(partition.get(true)));
            else
                return sumNumbers(partition.get(false));
        }
    }

    private Integer sumNumbers(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    private String joinNumbersByDelimiter(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(defaultDelimiter));
    }

    private Map<Boolean, List<Integer>> splitNegativeAndPositiveNumbers(String numbers) {
        return Arrays.stream(numbers.replaceAll("\n", defaultDelimiter).split(defaultDelimiter))
                        .map(Integer::valueOf)
                        .collect(Collectors.partitioningBy(i -> i < 0));
    }

    public static class NegativeNumbersException extends RuntimeException {
        public NegativeNumbersException(String numbers) {
            super("Negatives not allowed: " + numbers);
        }
    }
}
