// Last updated: 7/20/2026, 11:47:57 PM
1class Solution {
2    public int findDuplicate(int[] nums) {
3       int i=0;
4        while(i<nums.length){
5            int correct = nums[i]-1;
6            if(nums[i] != nums[correct]){
7                swap(nums,i,correct);
8
9            }
10            else{
11                i++;
12            }
13        }
14        for(int index=0;index<nums.length;index++){
15            if(nums[index] != index+1){
16                return nums[index];
17            }
18        }
19        return -1;
20    }
21    void swap(int[] a,int first, int second){
22        int temp = a[first];
23        a[first] = a[second];
24        a[second] = temp;
25
26    }
27}