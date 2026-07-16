// Last updated: 7/16/2026, 4:09:18 PM
class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max=nums[0],min=nums[0],sum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] >max){
                max=nums[i];
            }
            if(nums[i]<min){
                min = nums[i];
            }

        }
        sum=max-min;
        return k*(long)sum;
    }
}