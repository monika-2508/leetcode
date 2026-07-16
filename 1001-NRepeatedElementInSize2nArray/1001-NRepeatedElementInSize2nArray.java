// Last updated: 7/16/2026, 4:11:05 PM
class Solution {
    public int repeatedNTimes(int[] nums) {
        for(int i=0;i<nums.length-2;i++)
        {
            if(nums[i]==nums[i+1]||nums[i]==nums[i+2]){
                return nums[i];
            }
            
        }
        return nums[nums.length-1];
    }
}