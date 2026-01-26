package com.vishnu.interview.problems.day007;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateCharacters {

    public Set<Character> findDuplicates(String input) {
        Objects.requireNonNull(input, "Input string cannot be null");
        Set<Character> seen = new HashSet<>();

        return input.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !seen.add(c))
                .collect(Collectors.toSet());
    }
}
