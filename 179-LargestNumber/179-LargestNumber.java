// Last updated: 7/16/2026, 4:12:57 PM
import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        // Step 1: Convert the integer array to a string array
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Step 2: Sort the strings using our custom comparator
        Arrays.sort(asStrs, (a, b) -> (b + a).compareTo(a + b));

        // Step 3: Handle the edge case where the largest number is "0"
        // (e.g., nums = [0, 0]), we should return "0" instead of "00"
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Step 4: Build the final largest number string
        StringBuilder largestNumberStr = new StringBuilder();
        for (String numAsStr : asStrs) {
            largestNumberStr.append(numAsStr);
        }

        return largestNumberStr.toString();
    }
}