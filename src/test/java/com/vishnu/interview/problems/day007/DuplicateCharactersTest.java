package com.vishnu.interview.problems.day007;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Day 07: Duplicate Characters")
class DuplicateCharactersTest {

    private final DuplicateCharacters solution = new DuplicateCharacters();

    @ParameterizedTest(name = "Test {index}: findDuplicates(''{0}'')")
    @MethodSource("provideTestCases")
    @DisplayName("Should find duplicate characters")
    void testFindDuplicates(String input, Set<Character> expected) {
        Set<Character> actual = solution.findDuplicates(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should throw NullPointerException when input is null")
    void testPalindrome_NullInput_ThrowsException() {
        assertThatThrownBy(() -> solution.findDuplicates(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Input string cannot be null");
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("programming", Set.of('r', 'g', 'm')),
                Arguments.of("hello", Set.of('l')),
                Arguments.of("", Set.of()),
                Arguments.of("abc", Set.of()),
                Arguments.of("aabbcc", Set.of('a', 'b', 'c')),
                Arguments.of("aaa", Set.of('a'))
        );
    }
}
