// Last updated: 9/15/2026, 9:15:34 AM
1class Solution {
2    public int countDigitOne(int n) {
3        int count = 0;
4
5        for (long i = 1; i <= n; i *= 10) {
6            long divider = i * 10;
7            // Full complete cycles of 10^k
8            count += (n / divider) * i;
9            // Partial remainder cycle
10            count += Math.min(Math.max(n % divider - i + 1, 0), i);
11        }
12
13        return count;
14    }
15}