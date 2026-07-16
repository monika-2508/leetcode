// Last updated: 7/16/2026, 4:12:28 PM
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expected = n*(n+1)/2;
        int actual = 0;
        for(int x:nums){
            actual += x;
        }
        return expected - actual;
    }
}