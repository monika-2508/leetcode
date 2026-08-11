// Last updated: 8/11/2026, 8:54:12 AM
1class Solution {
2    public String longestPalindrome(String s) {
3        if (s == null || s.length() < 1) return "";
4        
5        int start = 0, end = 0;
6        
7        for (int i = 0; i < s.length(); i++) {
8            // Expand around single character center (odd length palindromes)
9            int len1 = expandAroundCenter(s, i, i);
10            // Expand around two-character center (even length palindromes)
11            int len2 = expandAroundCenter(s, i, i + 1);
12            
13            int maxLen = Math.max(len1, len2);
14            
15            if (maxLen > end - start) {
16                start = i - (maxLen - 1) / 2;
17                end = i + maxLen / 2;
18            }
19        }
20        
21        return s.substring(start, end + 1);
22    }
23    
24    private int expandAroundCenter(String s, int left, int right) {
25        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
26            left--;
27            right++;
28        }
29        return right - left - 1;
30    }
31}