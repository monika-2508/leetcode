// Last updated: 9/21/2026, 1:16:57 PM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<String> summaryRanges(int[] nums) {
6        List<String> result = new ArrayList<>();
7        int n = nums.length;
8        
9        for (int i = 0; i < n; i++) {
10            int start = nums[i];
11            
12            // Advance while consecutive numbers form a continuous range
13            while (i + 1 < n && nums[i + 1] == nums[i] + 1) {
14                i++;
15            }
16            
17            // Format range: either "a->b" or "a"
18            if (start != nums[i]) {
19                result.add(start + "->" + nums[i]);
20            } else {
21                result.add(String.valueOf(start));
22            }
23        }
24        
25        return result;
26    }
27}