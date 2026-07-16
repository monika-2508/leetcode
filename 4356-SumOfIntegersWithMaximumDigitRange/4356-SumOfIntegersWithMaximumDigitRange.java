// Last updated: 7/16/2026, 4:09:04 PM
class Solution {
    public int maxDigitRange(int[] nums) {
        int maxRange = -1;
        
        // Step 1: Find the maximum digit range
        for (int num : nums) {
            int range = getDigitRange(num);
            if (range > maxRange) {
                maxRange = range;
            }
        }
        
        // Step 2: Sum all integers that have the maximum digit range
        int sum = 0;
        for (int num : nums) {
            if (getDigitRange(num) == maxRange) {
                sum += num;
            }
        }
        
        return sum;
    }
    
    // Helper method to calculate the digit range of a number
    private int getDigitRange(int num) {
        int maxDigit = 0;
        int minDigit = 9;
        
        while (num > 0) {
            int digit = num % 10;
            if (digit > maxDigit) maxDigit = digit;
            if (digit < minDigit) minDigit = digit;
            num /= 10;
        }
        
        return maxDigit - minDigit;
    }
}