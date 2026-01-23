package com.vishnu.interview.problems.day005;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Day 05: Reverse Words in Sentence")
class ReverseWordsInSentenceTest {

    private final ReverseWordsInSentence solution = new ReverseWordsInSentence();

    @ParameterizedTest(name = "Test {index}: reverseWords(''{0}'') = ''{1}''")
    @MethodSource("provideTestCases")
    @DisplayName("Should reverse each word in sentence")
    void testReverseWords(String input, String expected) {
        String actual = solution.reverseWords(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should throw NullPointerException when input is null")
    void testPalindrome_NullInput_ThrowsException() {
        assertThatThrownBy(() -> solution.reverseWords(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Input string cannot be null");
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("Hello World", "olleH dlroW"),
                Arguments.of("Java Programming", "avaJ gnimmargorP"),
                Arguments.of("", ""),
                Arguments.of("Single", "elgniS"),
                Arguments.of("a b c", "a b c"),
                Arguments.of("The quick brown fox", "ehT kciuq nworb xof")
        );
    }
}