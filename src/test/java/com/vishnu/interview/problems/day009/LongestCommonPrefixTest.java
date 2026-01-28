package com.vishnu.interview.problems.day009;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Day 09: Longest Common Prefix")
class LongestCommonPrefixTest {

    private final LongestCommonPrefix solution = new LongestCommonPrefix();

    @ParameterizedTest(name = "Test {index}: findLongestCommonPrefix({0}) = ''{1}''")
    @MethodSource("provideTestCases")
    @DisplayName("Should find longest common prefix")
    void testFindLongestCommonPrefix(List<String> input, String expected) {
        String actual = solution.findLongestCommonPrefix(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should throw NullPointerException when input is null")
    void testPalindrome_NullInput_ThrowsException() {
        assertThatThrownBy(() -> solution.findLongestCommonPrefix(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Input cannot be null");
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(List.of("flower", "flow", "flight"), "fl"),
                Arguments.of(List.of("dog", "racecar", "car"), ""),
                Arguments.of(List.of("interspecies", "interstellar", "interstate"), "inters"),
                Arguments.of(List.of("prefix", "prefix", "prefix"), "prefix"),
                Arguments.of(List.of(""), ""),
                Arguments.of(List.of("single"), "single"),
                Arguments.of(List.of("abc", "ab", "abcd"), "ab")
        );
    }
}
