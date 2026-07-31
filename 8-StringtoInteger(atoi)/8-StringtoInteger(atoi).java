// Last updated: 7/31/2026, 9:05:23 AM
1class Solution {
2    public boolean isMatch(String s, String p) {
3        int m = s.length();
4        int n = p.length();
5
6        // dp[i][j] represents if s[0...i-1] matches p[0...j-1]
7        boolean[][] dp = new boolean[m + 1][n + 1];
8
9        // Base case: empty string matches empty pattern
10        dp[0][0] = true;
11
12        // Base case: patterns like "a*", "a*b*", "a*b*c*" can match an empty string
13        for (int j = 2; j <= n; j++) {
14            if (p.charAt(j - 1) == '*') {
15                dp[0][j] = dp[0][j - 2];
16            }
17        }
18
19        // Fill DP table
20        for (int i = 1; i <= m; i++) {
21            for (int j = 1; j <= n; j++) {
22                char charS = s.charAt(i - 1);
23                char charP = p.charAt(j - 1);
24
25                if (charP == '.' || charP == charS) {
26                    // Match current single character
27                    dp[i][j] = dp[i - 1][j - 1];
28                } else if (charP == '*') {
29                    // Option 1: Treat '*' as 0 occurrences of preceding character
30                    dp[i][j] = dp[i][j - 2];
31
32                    // Option 2: Treat '*' as 1 or more occurrences (if preceding character matches)
33                    char prevP = p.charAt(j - 2);
34                    if (prevP == '.' || prevP == charS) {
35                        dp[i][j] = dp[i][j] || dp[i - 1][j];
36                    }
37                }
38            }
39        }
40
41        return dp[m][n];
42    }
43}