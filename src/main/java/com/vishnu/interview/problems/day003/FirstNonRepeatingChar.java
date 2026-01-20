package com.vishnu.interview.problems.day003;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

class FirstNonRepeatingChar {

    public Character findFirst(String input) {
        Objects.requireNonNull(input, "Input string cannot be null");
        Map<Character, Long> characterFrequencies = buildFrequencyMap(input);
        return findFirstUniqueCharacter(characterFrequencies).orElse(null);
    }

    private Map<Character, Long> buildFrequencyMap(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));
    }

    private Optional<Character> findFirstUniqueCharacter(Map<Character, Long> frequencies) {
        return frequencies.entrySet().stream()
                .filter(this::isUnique)
                .map(Entry::getKey)
                .findFirst();
    }

    private boolean isUnique(Entry<Character, Long> entry) {
        return entry.getValue() == 1;
    }
}