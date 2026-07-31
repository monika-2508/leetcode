// Last updated: 7/31/2026, 9:24:57 AM
1class Solution {
2    public int titleToNumber(String columnTitle) {
3        int result = 0;
4
5        for (int i = 0; i < columnTitle.length(); i++) {
6            char c = columnTitle.charAt(i);
7            int value = c - 'A' + 1; // 'A' -> 1, 'B' -> 2, ..., 'Z' -> 26
8            result = result * 26 + value;
9        }
10
11        return result;
12    }
13}