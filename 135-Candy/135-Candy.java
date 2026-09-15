// Last updated: 9/15/2026, 9:06:54 AM
1import java.util.Arrays;
2
3class Solution {
4    public int candy(int[] ratings) {
5        int n = ratings.length;
6        int[] candies = new int[n];
7        Arrays.fill(candies, 1);
8
9        // Left-to-right pass
10        for (int i = 1; i < n; i++) {
11            if (ratings[i] > ratings[i - 1]) {
12                candies[i] = candies[i - 1] + 1;
13            }
14        }
15
16        // Right-to-left pass & calculate sum
17        int totalCandies = candies[n - 1];
18        for (int i = n - 2; i >= 0; i--) {
19            if (ratings[i] > ratings[i + 1]) {
20                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
21            }
22            totalCandies += candies[i];
23        }
24
25        return totalCandies;
26    }
27}