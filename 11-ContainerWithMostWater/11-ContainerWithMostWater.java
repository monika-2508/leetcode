// Last updated: 8/11/2026, 9:57:20 AM
1class Solution {
2    public int maxArea(int[] height) {
3        int left = 0;
4        int right = height.length - 1;
5        int maxA = 0;
6        while(left < right){
7            int cw=right-left;
8            int ch = Math.min(height[left],height[right]);
9            int ca = cw*ch;
10            maxA=Math.max(maxA,ca);
11            if(height[left] < height[right]){
12                left++;
13            }
14            else{
15                right--;
16            }
17        }
18        return maxA;
19    }
20}