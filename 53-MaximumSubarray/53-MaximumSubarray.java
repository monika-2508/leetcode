// Last updated: 7/16/2026, 4:13:40 PM
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentSum=nums[0];
        for(int i=1;i<nums.length;i++){
            int num = nums[i];
            currentSum = Math.max(num,currentSum+num);
            max = Math.max(max,currentSum);
        }return max;
    }
}