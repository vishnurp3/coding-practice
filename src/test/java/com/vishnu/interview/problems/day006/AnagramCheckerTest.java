package com.vishnu.interview.problems.day006;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Day 06: Anagram Checker")
class AnagramCheckerTest {

    private final AnagramChecker solution = new AnagramChecker();

    @ParameterizedTest(name = "Test {index}: areAnagrams(''{0}'', ''{1}'') = {2}")
    @MethodSource("provideTestCases")
    @DisplayName("Should check anagrams correctly")
    void testAreAnagrams(String str1, String str2, boolean expected) {
        boolean actual = solution.areAnagrams(str1, str2);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("listen", "silent", true),
                Arguments.of("hello", "world", false),
                Arguments.of("", "", true),
                Arguments.of("a", "a", true),
                Arguments.of("ab", "ba", true),
                Arguments.of("abc", "bca", true),
                Arguments.of("Listen", "Silent", false),
                Arguments.of("anagram", "nagaram", true),
                Arguments.of("rat", "car", false)
        );
    }
}
