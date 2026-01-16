package com.vishnu.interview.problems.day001;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Day 01: Reverse String")
class ReverseStringTest {

    private final ReverseString solution = new ReverseString();

    @ParameterizedTest(name = "Test {index}: reverse(''{0}'') = ''{1}''")
    @MethodSource("provideTestCases")
    @DisplayName("Should reverse string correctly")
    void testReverse(String input, String expected) {
        String actual = solution.reverse(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should throw NullPointerException when input is null")
    void testReverse_NullInput_ThrowsException() {
        assertThatThrownBy(() -> solution.reverse(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Input string cannot be null");
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("hello", "olleh"),
                Arguments.of("world", "dlrow"),
                Arguments.of("", ""),
                Arguments.of("a", "a"),
                Arguments.of("ab", "ba"),
                Arguments.of("racecar", "racecar"),
                Arguments.of("Java", "avaJ"),
                Arguments.of("12345", "54321"),
                Arguments.of("Hello World!", "!dlroW olleH")
        );
    }
}