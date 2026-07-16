// Last updated: 7/16/2026, 4:09:55 PM
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        int current = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                current++;
            }
            else{
                count += (current*(current-1))/2;
                current = 1;
            }
        }
        count += (current*(current-1))/2;
        return count;
        
    }
}