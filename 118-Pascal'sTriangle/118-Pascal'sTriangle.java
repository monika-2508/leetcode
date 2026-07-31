// Last updated: 7/31/2026, 9:23:25 AM
1class Solution {
2    public int majorityElement(int[] nums) {
3        int candidate = 0;
4        int count = 0;
5
6        for (int num : nums) {
7            if (count == 0) {
8                candidate = num;
9            }
10            
11            count += (num == candidate) ? 1 : -1;
12        }
13
14        return candidate;
15    }
16}