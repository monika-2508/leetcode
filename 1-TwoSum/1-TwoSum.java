// Last updated: 7/16/2026, 4:14:02 PM
import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //According to brute force approach
        HashMap<Integer,Integer> s = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int c = target - nums[i];
            if(s.containsKey(c)) return new int[] {s.get(c),i};
            s.put(nums[i], i);
        }
        return new int[] {}; //empty array
    }
}