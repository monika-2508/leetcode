// Last updated: 9/1/2026, 9:27:45 AM
import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        // Base case 1: Strings are identical
        if (s1.equals(s2)) {
            return true;
        }

        // Base case 2: String lengths differ (should not happen per constraints)
        if (s1.length() != s2.length()) {
            return false;
        }

        // Check memoization table
        String key = s1 + "_" + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Pruning: If character counts do not match, s2 cannot be a scrambled version of s1
        int[] count = new int[26];
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) {
                memo.put(key, false);
                return false;
            }
        }

        // Try every possible split position i
        for (int i = 1; i < len; i++) {
            // Case 1: Substrings are NOT swapped
            // s1[0...i-1] matches s2[0...i-1] AND s1[i...len-1] matches s2[i...len-1]
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) {
                memo.put(key, true);
                return true;
            }

            // Case 2: Substrings ARE swapped
            // s1[0...i-1] matches s2[len-i...len-1] AND s1[i...len-1] matches s2[0...len-i-1]
            if (isScramble(s1.substring(0, i), s2.substring(len - i)) &&
                isScramble(s1.substring(i), s2.substring(0, len - i))) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }
}