package com.vishnu.interview.problems.day011;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Day 11: Second Largest Element")
class SecondLargestElementTest {

    private final SecondLargestElement solution = new SecondLargestElement();

    @ParameterizedTest(name = "Test {index}: findSecondLargest({0}) = {1}")
    @MethodSource("provideTestCases")
    @DisplayName("Should find the second largest distinct element")
    void testFindSecondLargest(int[] input, int expected) {
        int actual = solution.findSecondLargest(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should throw NullPointerException when input is null")
    void testSecondLargest_NullInput_ThrowsException() {
        assertThatThrownBy(() -> solution.findSecondLargest(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Input array cannot be null");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when array has fewer than two elements")
    void testSecondLargest_TooShort_ThrowsException() {
        assertThatThrownBy(() -> solution.findSecondLargest(new int[]{42}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input array must contain at least two elements");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when no second distinct element exists")
    void testSecondLargest_NoDistinct_ThrowsException() {
        assertThatThrownBy(() -> solution.findSecondLargest(new int[]{7, 7, 7}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input array must contain at least two distinct elements");
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{3, 5, 1, 2, 4}, 4),
                Arguments.of(new int[]{10, 9}, 9),
                Arguments.of(new int[]{5, 5, 4}, 4),
                Arguments.of(new int[]{-1, -5, -3}, -3),
                Arguments.of(new int[]{2, 1, 2, 3, 3, 4}, 3),
                Arguments.of(new int[]{Integer.MIN_VALUE, 0, Integer.MIN_VALUE}, Integer.MIN_VALUE)
        );
    }
}
