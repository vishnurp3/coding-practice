package com.vishnu.interview.problems.day005;

import java.util.Objects;

public class ReverseWordsInSentence {

    public String reverseWords(String sentence) {
        Objects.requireNonNull(sentence, "Input string cannot be null");

        char[] chars = sentence.toCharArray();
        int start = 0;
        for (int end = 0; end <= chars.length; end++) {
            if (end == chars.length || chars[end] == ' ') {
                reverseInPlace(chars, start, end - 1);
                start = end + 1;
            }
        }
        return new String(chars);
    }

    private void reverseInPlace(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
