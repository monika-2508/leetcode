// Last updated: 7/16/2026, 4:12:24 PM
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i<nums.length;i++){
            if(nums[i]!=0){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            j++;
            }
        }
    }
}