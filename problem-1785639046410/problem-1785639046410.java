// Last updated: 8/2/2026, 8:20:46 AM
1class Solution {
2    public long maxPairStrength(int[] nums) {
3        long ans = 0;
4        int n = nums.length;
5        for(int i=0;i<n;i++){
6            for(int j=i+1;j<n;j++){
7                long g = gcd(nums[i],nums[j]);
8                long strength = (1L * nums[i]*nums[j])/(g*g);
9                ans = Math.max(ans,strength);
10            }
11        }
12        return ans;
13    }
14    private long gcd(long a,long b){
15        while(b!=0){
16            long temp = a%b;
17            a=b;
18            b=temp;
19        }
20        return a;
21    }
22}