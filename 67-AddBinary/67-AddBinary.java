// Last updated: 7/17/2026, 2:50:56 PM
1class Solution {
2    public int longestValidParentheses(String s) {
3        int maxLen = 0;
4        int left = 0;
5        int right = 0;
6
7        for (int i = 0; i < s.length(); i++) {
8            if (s.charAt(i) == '(') {
9                left++;
10            } else {
11                right++;
12            }
13            if (left == right) {
14                maxLen = Math.max(maxLen, 2 * right);
15            } else if (right > left) {
16                left = 0;
17                right = 0;
18            }
19        }
20
21        left = 0;
22        right = 0;
23
24        for (int i = s.length() - 1; i >= 0; i--) {
25            if (s.charAt(i) == '(') {
26                left++;
27            } else {
28                right++;
29            }
30            if (left == right) {
31                maxLen = Math.max(maxLen, 2 * left);
32            } else if (left > right) {
33                left = 0;
34                right = 0;
35            }
36        }
37
38        return maxLen;
39    }
40}