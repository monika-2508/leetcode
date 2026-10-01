// Last updated: 10/1/2026, 9:38:32 AM
1import java.util.HashMap;
2import java.util.Map;
3
4class Solution {
5    public int numberOfArithmeticSlices(int[] nums) {
6        int n = nums.length;
7        if (n < 3) {
8            return 0;
9        }
10
11        int totalCount = 0;
12        // dp[i] maps difference -> count of subsequences ending at index i with that difference
13        Map<Long, Integer>[] dp = new HashMap[n];
14
15        for (int i = 0; i < n; i++) {
16            dp[i] = new HashMap<>();
17
18            for (int j = 0; j < i; j++) {
19                long diff = (long) nums[i] - nums[j];
20
21                int prevCount = dp[j].getOrDefault(diff, 0);
22
23                // Any arithmetic subsequence ending at j of length >= 2 extended by nums[i]
24                // forms a valid subsequence of length >= 3
25                totalCount += prevCount;
26
27                // Add existing subsequences extended by nums[i] plus the pair [nums[j], nums[i]]
28                int currentCount = dp[i].getOrDefault(diff, 0);
29                dp[i].put(diff, currentCount + prevCount + 1);
30            }
31        }
32
33        return totalCount;
34    }
35}