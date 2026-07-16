// Last updated: 7/16/2026, 4:13:43 PM
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            while(nums[i]>=1 && nums[i]<=n && nums[nums[i]-1]!=nums[i]){
                int cor=nums[i]-1;
                int temp=nums[i];
                nums[i]=nums[cor];
                nums[cor]=temp;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }
}