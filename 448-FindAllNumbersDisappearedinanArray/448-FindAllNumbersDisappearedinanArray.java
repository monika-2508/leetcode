// Last updated: 7/19/2026, 4:59:16 PM
1class Solution {
2    public List<Integer> findDisappearedNumbers(int[] nums) {
3        int i=0;
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
14        List<Integer> ans = new ArrayList<>();
15        for(int index=0;index<nums.length;index++){
16            if(nums[index] != index+1){
17                ans.add(index+1);
18            }
19        }
20        return ans;
21    }
22    void swap(int[] a,int first, int second){
23        int temp = a[first];
24        a[first] = a[second];
25        a[second] = temp;
26
27    }
28}