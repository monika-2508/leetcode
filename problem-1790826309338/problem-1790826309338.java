// Last updated: 10/1/2026, 9:15:09 AM
1class Solution {
2    public int thirdMax(int[] nums) {
3        Long max1 = null;
4        Long max2 = null;
5        Long max3 = null;
6
7        for (int num : nums) {
8            long n = (long) num;
9
10            // Skip duplicate values
11            if ((max1 != null && n == max1) || 
12                (max2 != null && n == max2) || 
13                (max3 != null && n == max3)) {
14                continue;
15            }
16
17            if (max1 == null || n > max1) {
18                max3 = max2;
19                max2 = max1;
20                max1 = n;
21            } else if (max2 == null || n > max2) {
22                max3 = max2;
23                max2 = n;
24            } else if (max3 == null || n > max3) {
25                max3 = n;
26            }
27        }
28
29        // If the third distinct maximum doesn't exist, return the maximum
30        return max3 == null ? max1.intValue() : max3.intValue();
31    }
32}