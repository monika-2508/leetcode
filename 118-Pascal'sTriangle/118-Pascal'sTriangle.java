// Last updated: 7/31/2026, 9:21:58 AM
1class Solution {
2    public String convertToTitle(int columnNumber) {
3        StringBuilder result = new StringBuilder();
4
5        while (columnNumber > 0) {
6            columnNumber--; // Adjust for 1-based indexing (0 -> 'A', 25 -> 'Z')
7            char remainder = (char) ('A' + (columnNumber % 26));
8            result.append(remainder);
9            columnNumber /= 26;
10        }
11
12        return result.reverse().toString();
13    }
14}