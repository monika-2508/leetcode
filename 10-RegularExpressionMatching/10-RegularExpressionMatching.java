// Last updated: 9/1/2026, 9:29:05 AM
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // dp[i][j] represents if s[0...i-1] matches p[0...j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case: empty string matches empty pattern
        dp[0][0] = true;

        // Base case: patterns like "a*", "a*b*", "a*b*c*" can match an empty string
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char charS = s.charAt(i - 1);
                char charP = p.charAt(j - 1);

                if (charP == '.' || charP == charS) {
                    // Match current single character
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (charP == '*') {
                    // Option 1: Treat '*' as 0 occurrences of preceding character
                    dp[i][j] = dp[i][j - 2];

                    // Option 2: Treat '*' as 1 or more occurrences (if preceding character matches)
                    char prevP = p.charAt(j - 2);
                    if (prevP == '.' || prevP == charS) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}