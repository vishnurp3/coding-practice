package com.vishnu.interview.problems.day010;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Day 10: Vowel and Consonant Counter")
class VowelConsonantCounterTest {

    private final VowelConsonantCounter solution = new VowelConsonantCounter();

    @ParameterizedTest(name = "Test {index}: count(''{0}'') = {1}")
    @MethodSource("provideTestCases")
    @DisplayName("Should count vowels and consonants correctly")
    void testCount(String input, VowelConsonantCounter.Count expected) {
        VowelConsonantCounter.Count actual = solution.count(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should throw NullPointerException when input is null")
    void testPalindrome_NullInput_ThrowsException() {
        assertThatThrownBy(() -> solution.count(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Input string cannot be null");
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("hello", new VowelConsonantCounter.Count(2, 3)),
                Arguments.of("programming", new VowelConsonantCounter.Count(3, 8)),
                Arguments.of("aeiou", new VowelConsonantCounter.Count(5, 0)),
                Arguments.of("bcdfg", new VowelConsonantCounter.Count(0, 5)),
                Arguments.of("", new VowelConsonantCounter.Count(0, 0)),
                Arguments.of("a", new VowelConsonantCounter.Count(1, 0)),
                Arguments.of("b", new VowelConsonantCounter.Count(0, 1)),
                Arguments.of("Hello World!", new VowelConsonantCounter.Count(3, 7))
        );
    }
}
