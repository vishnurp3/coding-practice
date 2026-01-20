package com.vishnu.interview.problems.day003;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Day 03: First Non-Repeating Character")
class FirstNonRepeatingCharTest {

    private final FirstNonRepeatingChar solution = new FirstNonRepeatingChar();

    @ParameterizedTest(name = "Test {index}: findFirst(''{0}'') = ''{1}''")
    @MethodSource("provideTestCases")
    @DisplayName("Should find first non-repeating character")
    void testFindFirst(String input, Character expected) {
        Character actual = solution.findFirst(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should throw NullPointerException when input is null")
    void testPalindrome_NullInput_ThrowsException() {
        assertThatThrownBy(() -> solution.findFirst(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Input string cannot be null");
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("leetcode", 'l'),
                Arguments.of("loveleetcode", 'v'),
                Arguments.of("aabb", null),
                Arguments.of("", null),
                Arguments.of("a", 'a'),
                Arguments.of("aabbccdef", 'd'),
                Arguments.of("swiss", 'w'),
                Arguments.of("aabbcc", null)
        );
    }
}
