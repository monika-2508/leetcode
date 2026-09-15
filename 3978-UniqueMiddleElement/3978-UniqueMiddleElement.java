// Last updated: 9/15/2026, 9:18:57 AM
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