// Last updated: 9/21/2026, 1:18:20 PM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<Integer> majorityElement(int[] nums) {
6        List<Integer> result = new ArrayList<>();
7        if (nums == null || nums.length == 0) return result;
8
9        // There can be at most two elements that appear more than n / 3 times.
10        Integer candidate1 = null, candidate2 = null;
11        int count1 = 0, count2 = 0;
12
13        // 1st Pass: Find the two potential candidates
14        for (int num : nums) {
15            if (candidate1 != null && num == candidate1) {
16                count1++;
17            } else if (candidate2 != null && num == candidate2) {
18                count2++;
19            } else if (count1 == 0) {
20                candidate1 = num;
21                count1 = 1;
22            } else if (count2 == 0) {
23                candidate2 = num;
24                count2 = 1;
25            } else {
26                count1--;
27                count2--;
28            }
29        }
30
31        // 2nd Pass: Verify if the candidates actually appear > n / 3 times
32        count1 = 0;
33        count2 = 0;
34        for (int num : nums) {
35            if (candidate1 != null && num == candidate1) count1++;
36            if (candidate2 != null && num == candidate2) count2++;
37        }
38
39        int threshold = nums.length / 3;
40        if (count1 > threshold) result.add(candidate1);
41        if (count2 > threshold) result.add(candidate2);
42
43        return result;
44    }
45}