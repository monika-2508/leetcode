// Last updated: 7/21/2026, 12:22:15 AM
1class Solution {
2    public int[] findErrorNums(int[] nums) {
3        int i=0;
4        while(i<nums.length){
5            
6            int correct = nums[i] - 1;
7            if(nums[i] != nums[correct]){
8                swap(nums,i,correct);
9            }
10            else{
11                i++;
12            }
13            
14        }
15        for(int index = 0;index < nums.length;index++){
16            if(nums[index] != index+1){
17                return new int[] {nums[index], index+1};
18            }
19        }
20
21        return new int[] {-1, -1};
22    }
23    public static void swap(int[] nums, int first, int second){
24        int temp = nums[first];
25        nums[first] = nums[second];
26        nums[second] = temp;
27    }
28}