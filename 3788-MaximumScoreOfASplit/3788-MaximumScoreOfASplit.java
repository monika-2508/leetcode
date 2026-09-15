// Last updated: 9/15/2026, 9:19:33 AM
class Solution {
    public long maximumScore(int[] nums) {
        int n = nums.length;
        long score = 0;
        int[] suffix = new int[n]; 
        suffix[n-1] = nums[n-1];
        for(int i = n-2 ; i >= 0; i--){
            suffix[i] = Math.min(nums[i],suffix[i+1]);
        }
        long prefix = 0;
        long max = Long.MIN_VALUE;
        for(int i=0;i<n-1 ;i++){
            prefix += nums[i]; 
            score = prefix - suffix[i+1];
            max = Math.max(max,score);
        }
        return max;
    }
}