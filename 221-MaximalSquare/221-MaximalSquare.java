// Last updated: 9/21/2026, 1:10:16 PM
1class Solution {
2    public int maximalSquare(char[][] matrix) {
3        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
4
5        int m = matrix.length;
6        int n = matrix[0].length;
7        int[][] dp = new int[m + 1][n + 1];
8        int maxSide = 0;
9
10        for (int i = 1; i <= m; i++) {
11            for (int j = 1; j <= n; j++) {
12                if (matrix[i - 1][j - 1] == '1') {
13                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
14                    maxSide = Math.max(maxSide, dp[i][j]);
15                }
16            }
17        }
18
19        return maxSide * maxSide;
20    }
21}