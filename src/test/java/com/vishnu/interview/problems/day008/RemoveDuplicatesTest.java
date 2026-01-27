package com.vishnu.interview.problems.day008;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Day 08: Remove Duplicates")
class RemoveDuplicatesTest {

    private final RemoveDuplicates solution = new RemoveDuplicates();

    @ParameterizedTest(name = "Test {index}: removeDuplicates(''{0}'') = ''{1}''")
    @MethodSource("provideTestCases")
    @DisplayName("Should remove duplicate characters while preserving order")
    void testRemoveDuplicates(String input, String expected) {
        String actual = solution.removeDuplicates(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should throw NullPointerException when input is null")
    void testPalindrome_NullInput_ThrowsException() {
        assertThatThrownBy(() -> solution.removeDuplicates(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Input string cannot be null");
    }


    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("programming", "progamin"),
                Arguments.of("hello", "helo"),
                Arguments.of("", ""),
                Arguments.of("a", "a"),
                Arguments.of("aabbcc", "abc"),
                Arguments.of("abcabc", "abc"),
                Arguments.of("aaa", "a")
        );
    }
}
