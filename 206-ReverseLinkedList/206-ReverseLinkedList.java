// Last updated: 9/1/2026, 9:23:20 AM
1class Solution {
2    public int strStr(String haystack, String needle) {
3        int hLen = haystack.length();
4        int nLen = needle.length();
5
6        if (nLen > hLen) return -1;
7
8        for (int i = 0; i <= hLen - nLen; i++) {
9            if (haystack.substring(i, i + nLen).equals(needle)) {
10                return i;
11            }
12        }
13
14        return -1;
15    }
16}