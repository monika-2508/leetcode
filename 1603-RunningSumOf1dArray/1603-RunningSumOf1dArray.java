// Last updated: 7/16/2026, 4:09:58 PM
class Solution {
    public int[] runningSum(int[] nums) {
        
         for(int i = 1;i<nums.length;i++){
            nums[i] = nums[i] + nums[i-1];
         }
        return nums;
    }
}