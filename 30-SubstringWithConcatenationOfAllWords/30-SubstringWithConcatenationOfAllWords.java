// Last updated: 9/1/2026, 9:28:38 AM
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int totalWords = words.length;
        int totalLen = wordLen * totalWords;

        if (s.length() < totalLen) {
            return result;
        }

        // Count frequency of each word in the input array
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        // Run sliding window for each possible starting index shift (0 to wordLen - 1)
        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> currentCounts = new HashMap<>();
            int left = i;
            int count = 0;

            for (int right = i; right <= s.length() - wordLen; right += wordLen) {
                String sub = s.substring(right, right + wordLen);

                if (wordCounts.containsKey(sub)) {
                    currentCounts.put(sub, currentCounts.getOrDefault(sub, 0) + 1);
                    count++;

                    // If a word appears more times than expected, shrink window from left
                    while (currentCounts.get(sub) > wordCounts.get(sub)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentCounts.put(leftWord, currentCounts.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // If valid window contains all words
                    if (count == totalWords) {
                        result.add(left);
                    }
                } else {
                    // Invalid word found: reset window
                    currentCounts.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return result;
    }
}