// Last updated: 9/1/2026, 9:29:27 AM
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        // Map to store the last seen index of each character
        HashMap<Character, Integer> charMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If character is already in the map and within the current window,
            // move left pointer right past the previous index of currentChar
            if (charMap.containsKey(currentChar)) {
                left = Math.max(left, charMap.get(currentChar) + 1);
            }

            charMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}