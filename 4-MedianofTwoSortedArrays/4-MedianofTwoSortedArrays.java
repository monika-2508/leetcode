// Last updated: 7/16/2026, 4:14:28 PM
1class Solution {
2    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
3       
4        if (nums1.length > nums2.length) {
5            return findMedianSortedArrays(nums2, nums1);
6        }
7        
8        int m = nums1.length;
9        int n = nums2.length;
10        int low = 0, high = m;
11        
12        while (low <= high) {
13            int i = (low + high) / 2;
14            int j = (m + n + 1) / 2 - i;
15            
16           
17            int maxLeft1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
18            int minRight1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
19            
20            int maxLeft2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
21            int minRight2 = (j == n) ? Integer.MAX_VALUE : nums2[j];
22           
23            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
24                
25                if ((m + n) % 2 != 0) {
26                    return Math.max(maxLeft1, maxLeft2);
27                }
28               
29                return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
30            } 
31            else if (maxLeft1 > minRight2) {
32             
33                high = i - 1;
34            } 
35            else {
36                
37                low = i + 1;
38            }
39        }
40        
41        return 0.0;
42    }
43}