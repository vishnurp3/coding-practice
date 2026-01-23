package com.vishnu.interview.problems.day004;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Day 04: Character Frequency")
class CharacterFrequencyTest {

    private final CharacterFrequency solution = new CharacterFrequency();

    @ParameterizedTest(name = "Test {index}: countFrequency(''{0}'')")
    @MethodSource("provideTestCases")
    @DisplayName("Should count character frequency correctly")
    void testCountFrequency(String input, Map<Character, Integer> expected) {
        Map<Character, Integer> actual = solution.countFrequency(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should throw NullPointerException when input is null")
    void testPalindrome_NullInput_ThrowsException() {
        assertThatThrownBy(() -> solution.countFrequency(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Input string cannot be null");
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("hello",
                        Map.of('h', 1, 'e', 1, 'l', 2, 'o', 1)),
                Arguments.of("aabbcc",
                        Map.of('a', 2, 'b', 2, 'c', 2)),
                Arguments.of("", Map.of()),
                Arguments.of("a", Map.of('a', 1)),
                Arguments.of("programming",
                        Map.of('p', 1, 'r', 2, 'o', 1, 'g', 2, 'a', 1, 'm', 2, 'i', 1, 'n', 1))
        );
    }
}
