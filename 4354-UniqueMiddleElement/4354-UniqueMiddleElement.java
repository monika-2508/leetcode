// Last updated: 7/16/2026, 4:09:08 PM
class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        // Find the middle element
        int midIndex = nums.length / 2;
        int target = nums[midIndex];
        int count = 0;
        
        // Count how many times the middle element appears
        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }
        
        // Return true if it appears exactly once
        return count == 1;
    }
}