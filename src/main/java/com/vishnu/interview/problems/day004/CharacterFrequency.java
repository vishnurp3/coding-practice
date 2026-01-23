package com.vishnu.interview.problems.day004;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterFrequency {

    public Map<Character, Integer> countFrequency(String input) {
        Objects.requireNonNull(input, "Input string cannot be null");

        return input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        HashMap::new,
                        Collectors.summingInt(c -> 1)
                ));
    }
}