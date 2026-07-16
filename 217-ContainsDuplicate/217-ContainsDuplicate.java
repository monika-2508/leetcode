// Last updated: 7/16/2026, 4:12:37 PM
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
                if(nums[i]==nums[i+1]){
                    return true;
                }
        }
        return false;
    }
}