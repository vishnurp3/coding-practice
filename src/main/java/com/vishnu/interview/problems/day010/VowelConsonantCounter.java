package com.vishnu.interview.problems.day010;

import java.util.Objects;

public class VowelConsonantCounter {

    public record Count(int vowels, int consonants) {
        @Override
        public String toString() {
            return "Count{vowels=" + vowels + ", consonants=" + consonants + '}';
        }
    }

    public Count count(String input) {
        Objects.requireNonNull(input, "Input string cannot be null");
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (!isAlphabet(currentChar)) continue;

            if (isVowel(currentChar)) {
                vowels++;
            } else {
                consonants++;
            }
        }
        return new Count(vowels, consonants);
    }

    private boolean isVowel(char input) {
        return input == 'a' || input == 'e' || input == 'i' || input == 'o' || input == 'u' ||
                input == 'A' || input == 'E' || input == 'I' || input == 'O' || input == 'U';
    }

    private boolean isAlphabet(char input) {
        return (input >= 'a' && input <= 'z') ||
                (input >= 'A' && input <= 'Z');
    }
}
