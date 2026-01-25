package com.vishnu.interview.problems.day006;

public class AnagramChecker {

    public boolean areAnagrams(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }

        if (str1.length() != str2.length()) {
            return false;
        }

        int[] frequencyCount = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            frequencyCount[str1.charAt(i)]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            char charAscii = str2.charAt(i);
            frequencyCount[charAscii]--;
            if (frequencyCount[charAscii] < 0) {
                return false;
            }

        }
        return true;
    }
}
