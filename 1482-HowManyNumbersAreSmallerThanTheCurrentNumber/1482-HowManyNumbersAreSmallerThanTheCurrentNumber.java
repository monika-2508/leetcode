// Last updated: 7/16/2026, 4:10:09 PM
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int count = 0;
            for(int j = 0; j < nums.length; j++){
                if(nums[j] < nums[i]){
                    count++;                    
                }
                arr[i] = count;
            }
        }
        return arr;
    }
}