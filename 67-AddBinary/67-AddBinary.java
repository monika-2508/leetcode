// Last updated: 7/17/2026, 2:52:36 PM
1class Solution {
2    public String shortestPalindrome(String s) {
3        if (s == null || s.length() <= 1) {
4            return s;
5        }
6
7        String temp = s + "#" + new StringBuilder(s).reverse().toString();
8        int[] lps = new int[temp.length()];
9
10        for (int i = 1; i < temp.length(); i++) {
11            int j = lps[i - 1];
12            while (j > 0 && temp.charAt(i) != temp.charAt(j)) {
13                j = lps[j - 1];
14            }
15            if (temp.charAt(i) == temp.charAt(j)) {
16                j++;
17            }
18            lps[i] = j;
19        }
20
21        int longestPalindromePrefixLen = lps[temp.length() - 1];
22        String suffixToAdd = s.substring(longestPalindromePrefixLen);
23        
24        return new StringBuilder(suffixToAdd).reverse().toString() + s;
25    }
26}