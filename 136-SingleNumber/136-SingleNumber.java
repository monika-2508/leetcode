// Last updated: 7/16/2026, 4:13:11 PM
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int x: nums){
            result ^= x;
        }
        return result;
    }
}