package com.ndiamanti.stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculatorImpl implements StringCalculator {

    private String DELIMITER = ",";

    @Override
    public Integer add(String numbers) {
        if (numbers.isEmpty())
            return 0;
        else {

            if (numbers.startsWith(DYNAMIC_DELIMITER_PREFIX)) {
                recognizeNumbersDelimiter(numbers);
                numbers = numbers.replaceFirst(DELIMITER_REGEX, "");
            }

            Map<Boolean, List<Integer>> partition = splitNegativeAndPositiveNumbers(numbers);
            if (!partition.get(true).isEmpty())
                throw new NegativeNumbersException(joinNumbersByDelimiter(partition.get(true)));
            else
                return sumNumbers(partition.get(false));
        }
    }

    private void recognizeNumbersDelimiter(String numbers) {
        Pattern pattern = Pattern.compile(DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(numbers);
        if (matcher.find()) {
            DELIMITER = matcher.group(1);
        }
    }

    private Integer sumNumbers(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    private String joinNumbersByDelimiter(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER));
    }

    private Map<Boolean, List<Integer>> splitNegativeAndPositiveNumbers(String numbers) {
        return Arrays.stream(numbers.replaceAll("\n", DELIMITER).split(DELIMITER))
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
