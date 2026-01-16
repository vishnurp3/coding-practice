package com.vishnu.interview.problems.day001;

import java.util.Objects;

class ReverseString {

    String reverse(String input) {
        Objects.requireNonNull(input, "Input string cannot be null");

        char[] chars = input.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }
        return new String(chars);
    }
}
