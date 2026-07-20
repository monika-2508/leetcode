// Last updated: 7/21/2026, 12:01:43 AM
1class Solution {
2    public List<Integer> findDuplicates(int[] nums) {
3        int i = 0;
4        while(i<nums.length){
5            int correct = nums[i] - 1;
6            if(nums[i] != nums[correct]){
7                swap(nums,i,correct);
8            }
9            else{
10                i++;
11            }
12        }
13        List<Integer> ans = new ArrayList<>();
14        for(int index=0;index<nums.length;index++){
15            if(nums[index] != index+1){
16                ans.add(nums[index]);
17            }
18        }
19        return ans;
20    }
21    public static void swap(int[] nums,int i, int correct){
22        int temp = nums[i];
23        nums[i] = nums[correct];
24        nums[correct]= temp;
25    }
26}