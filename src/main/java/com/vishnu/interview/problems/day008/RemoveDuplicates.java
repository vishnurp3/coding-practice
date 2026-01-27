package com.vishnu.interview.problems.day008;

import java.util.Objects;

public class RemoveDuplicates {

    public String removeDuplicates(String input) {
        Objects.requireNonNull(input, "Input string cannot be null");

        boolean[] seen = new boolean[256];
        StringBuilder sb = new StringBuilder(input.length());

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (!seen[currentChar]) {
                seen[currentChar] = true;
                sb.append(currentChar);
            }
        }

        return sb.toString();
    }
}
