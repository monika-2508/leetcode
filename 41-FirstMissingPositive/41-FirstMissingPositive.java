// Last updated: 8/2/2026, 12:45:06 PM
1class Solution {
2    public int firstMissingPositive(int[] nums) {
3        int i=0;
4        while(i<nums.length){
5            int correct = nums[i] - 1;
6            if(nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[correct]){
7                swap(nums, i, correct);
8            }
9            else{
10                i++;
11            }
12        }
13        for(int index = 0; index < nums.length; index++){
14            if(nums[index] != index + 1){
15                return index + 1;
16            }
17        }
18        return nums.length + 1;
19    }
20    static void swap(int[] nums, int first, int second){
21        int temp = nums[first];
22        nums[first] = nums[second];
23        nums[second] = temp;
24        
25    }
26}