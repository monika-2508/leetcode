// Last updated: 7/25/2026, 9:12:44 AM
1class Solution {
2    public boolean isMatch(String s, String p) {
3        int sIdx = 0, pIdx = 0;
4        int starIdx = -1, sTmpIdx = -1;
5
6        while (sIdx < s.length()) {
7            // Case 1: Match single character or '?' wildcard
8            if (pIdx < p.length() && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))) {
9                sIdx++;
10                pIdx++;
11            } 
12            // Case 2: Found '*' wildcard, record position and try matching 0 characters first
13            else if (pIdx < p.length() && p.charAt(pIdx) == '*') {
14                starIdx = pIdx;
15                sTmpIdx = sIdx;
16                pIdx++;
17            } 
18            // Case 3: Last seen character was '*', backtrack and match 1 more character in s
19            else if (starIdx != -1) {
20                pIdx = starIdx + 1;
21                sTmpIdx++;
22                sIdx = sTmpIdx;
23            } 
24            // Case 4: No match and no '*' to backtrack to
25            else {
26                return false;
27            }
28        }
29
30        // Check for remaining trailing '*' in pattern
31        while (pIdx < p.length() && p.charAt(pIdx) == '*') {
32            pIdx++;
33        }
34
35        return pIdx == p.length();
36    }
37}