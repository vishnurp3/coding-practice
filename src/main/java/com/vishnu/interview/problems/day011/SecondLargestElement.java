package com.vishnu.interview.problems.day011;

import java.util.Objects;

public class SecondLargestElement {

    public int findSecondLargest(int[] numbers) {
        Objects.requireNonNull(numbers, "Input array cannot be null");
        if (numbers.length < 2) {
            throw new IllegalArgumentException("Input array must contain at least two elements");
        }

        Integer largest = null;
        Integer secondLargest = null;

        for (int value : numbers) {
            if (largest == null || value > largest) {
                if (largest != null) {
                    secondLargest = largest;
                }
                largest = value;
            } else if (value != largest && (secondLargest == null || value > secondLargest)) {
                secondLargest = value;
            }
        }

        if (secondLargest == null) {
            throw new IllegalArgumentException("Input array must contain at least two distinct elements");
        }

        return secondLargest;
    }
}
