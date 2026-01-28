package com.vishnu.interview.problems.day009;

import java.util.List;
import java.util.Objects;

public class LongestCommonPrefix {

    public String findLongestCommonPrefix(List<String> strings) {
        Objects.requireNonNull(strings, "Input cannot be null");
        if (strings.isEmpty()) {
            return "";
        }
        if (strings.size() == 1) {
            return strings.getFirst();
        }

        List<String> sortedStrings = strings.stream().sorted().toList();

        String firstWord = sortedStrings.getFirst();
        String lastWord = sortedStrings.getLast();
        int characterIndex = 0;

        while (characterIndex < firstWord.length()) {
            if (firstWord.charAt(characterIndex) != lastWord.charAt(characterIndex)) {
                break;
            }
            characterIndex++;
        }

        return firstWord.substring(0, characterIndex);
    }
}
