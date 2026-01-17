package com.vishnu.interview.problems.day002;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Day 02: Palindrome Checker")
class PalindromeCheckerTest {

    private final PalindromeChecker solution = new PalindromeChecker();

    @ParameterizedTest(name = "Test {index}: isPalindrome(''{0}'') = {1}")
    @MethodSource("provideTestCases")
    @DisplayName("Should check palindrome correctly")
    void testIsPalindrome(String input, boolean expected) {
        boolean actual = solution.isPalindrome(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should throw NullPointerException when input is null")
    void testPalindrome_NullInput_ThrowsException() {
        assertThatThrownBy(() -> solution.isPalindrome(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Input string cannot be null");
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("racecar", true),
                Arguments.of("hello", false),
                Arguments.of("", true),
                Arguments.of("a", true),
                Arguments.of("ab", false),
                Arguments.of("aba", true),
                Arguments.of("madam", true),
                Arguments.of("Racecar", false),
                Arguments.of("12321", true),
                Arguments.of("noon", true)
        );
    }
}