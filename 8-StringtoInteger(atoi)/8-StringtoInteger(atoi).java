// Last updated: 7/31/2026, 9:18:04 AM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<List<Integer>> generate(int numRows) {
6        List<List<Integer>> triangle = new ArrayList<>();
7
8        for (int i = 0; i < numRows; i++) {
9            List<Integer> row = new ArrayList<>();
10            
11            for (int j = 0; j <= i; j++) {
12                // The first and last elements of each row are always 1
13                if (j == 0 || j == i) {
14                    row.add(1);
15                } else {
16                    // Middle elements: sum of the two elements directly above in the previous row
17                    int prevRowVal1 = triangle.get(i - 1).get(j - 1);
18                    int prevRowVal2 = triangle.get(i - 1).get(j);
19                    row.add(prevRowVal1 + prevRowVal2);
20                }
21            }
22            
23            triangle.add(row);
24        }
25
26        return triangle;
27    }
28}