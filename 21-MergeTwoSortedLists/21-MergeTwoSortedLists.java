// Last updated: 8/6/2026, 9:39:35 AM
1class Solution {
2    public int removeDuplicates(int[] nums) {
3        if (nums.length == 0) return 0;
4        
5        // Pointer for placing the next unique element
6        int k = 1;
7        
8        for (int i = 1; i < nums.length; i++) {
9            // Found a new unique element
10            if (nums[i] != nums[i - 1]) {
11                nums[k] = nums[i];
12                k++;
13            }
14        }
15        
16        return k;
17    }
18}