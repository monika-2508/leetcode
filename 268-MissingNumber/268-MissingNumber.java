// Last updated: 7/19/2026, 4:35:24 PM
1class Solution {
2    public int missingNumber(int[] nums) {
3        int i=0;
4        while(i<nums.length){
5          
6            int correct = nums[i];
7            if(nums[i]<nums.length && nums[i] != nums[correct]){
8                swap(nums,i,correct);
9            }
10            else{ 
11                i++;
12            }
13
14        }
15        for(int j=0;j<nums.length;j++){
16            if(nums[j]!=j){
17                return j;
18            }
19        }
20        return nums.length;
21
22    }
23    public static void swap(int[] arr,int first, int second){
24        int temp = arr[first];
25        arr[first] = arr[second];
26        arr[second] = temp;
27    }
28}