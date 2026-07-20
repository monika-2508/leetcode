// Last updated: 7/20/2026, 11:51:07 PM
1class Solution {
2    public int findDuplicate(int[] nums) {
3       int i=0;
4     
5        while(i<nums.length){
6            if(nums[i] != i+1)
7            {
8                int correct = nums[i]-1;
9                if(nums[i] != nums[correct]){
10                    swap(nums,i,correct);
11
12                }
13                else{
14                    return nums[i];
15                }
16            }
17            else{
18                i++;
19            }
20        }
21        return -1;
22    }
23    void swap(int[] a,int first, int second){
24        int temp = a[first];
25        a[first] = a[second];
26        a[second] = temp;
27
28    }
29}