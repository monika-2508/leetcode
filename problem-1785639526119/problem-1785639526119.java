// Last updated: 8/2/2026, 8:28:46 AM
1class Solution {
2    public int countRatioSubarrays(int[] nums, int a, int b) {
3        int n = nums.length;
4        long ans = 0;
5        for(int i=0;i<n;i++){
6            int even = 0,odd = 0;
7            for(int j=i;j<n;j++){
8                if((nums[j]&1)==0){
9                    even++;
10                }
11                else{
12                    odd++;
13                }
14                if(odd>0 && 1L * even * b <= 1L * odd * a){
15                    ans++;
16                }
17            }
18        }
19        return (int)ans;
20    }
21}