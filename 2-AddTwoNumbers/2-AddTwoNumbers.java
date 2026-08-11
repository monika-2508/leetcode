// Last updated: 8/11/2026, 8:53:15 AM
1import java.util.HashMap;
2
3class Solution {
4    public int lengthOfLongestSubstring(String s) {
5        int maxLength = 0;
6        int left = 0;
7        // Map to store the last seen index of each character
8        HashMap<Character, Integer> charMap = new HashMap<>();
9
10        for (int right = 0; right < s.length(); right++) {
11            char currentChar = s.charAt(right);
12
13            // If character is already in the map and within the current window,
14            // move left pointer right past the previous index of currentChar
15            if (charMap.containsKey(currentChar)) {
16                left = Math.max(left, charMap.get(currentChar) + 1);
17            }
18
19            charMap.put(currentChar, right);
20            maxLength = Math.max(maxLength, right - left + 1);
21        }
22
23        return maxLength;
24    }
25}