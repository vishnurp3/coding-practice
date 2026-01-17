package com.vishnu.interview.problems.day002;

import java.util.Objects;

class PalindromeChecker {

    boolean isPalindrome(String input) {
        Objects.requireNonNull(input, "Input string cannot be null");

        char[] chars = input.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}