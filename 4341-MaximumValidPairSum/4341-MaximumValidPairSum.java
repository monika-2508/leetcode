// Last updated: 7/16/2026, 4:09:02 PM
class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;
        int maxLeft = nums[0];
        int maxSum = Integer.MIN_VALUE;
        
        // Iterate through all possible right elements of the pair
        for (int j = k; j < n; j++) {
            // Update the maximum element available on the left side
            maxLeft = Math.max(maxLeft, nums[j - k]);
            
            // Update the global maximum pair sum
            maxSum = Math.max(maxSum, maxLeft + nums[j]);
        }
        
        return maxSum;
    }
}