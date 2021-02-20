package com.ndiamanti.stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringCalculatorImpl implements StringCalculator {

    @Override
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
                .collect(Collectors.joining(DEFAULT_DELIMITER));
    }

    private Map<Boolean, List<Integer>> splitNegativeAndPositiveNumbers(String numbers) {
        return Arrays.stream(numbers.replaceAll("\n", DEFAULT_DELIMITER).split(DEFAULT_DELIMITER))
                .map(Integer::valueOf)
                .filter(i -> i <= MAX_NUMBER_ALLOWED)
                .collect(Collectors.partitioningBy(i -> i < 0));
    }

    public static class NegativeNumbersException extends RuntimeException {
        public NegativeNumbersException(String numbers) {
            super("Negatives not allowed: " + numbers);
        }
    }
}
